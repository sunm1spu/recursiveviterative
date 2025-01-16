#include <iostream>
#include <chrono>
#include <ctime>
#include <cstdint>

double IterativePowerDouble(double base, int exponent);
double RecursivePowerDouble(double base, int exponent);
int IterativePowerInt(int base, int exponent);
int RecursivePowerInt(int base, int exponent);


int main() {
    double base1 = 2.0;
    int exp1 = 30; 

    auto start = std::chrono::high_resolution_clock::now();
    double result1 = IterativePowerDouble(base1, exp1);
    auto end = std::chrono::high_resolution_clock::now();
    std::cout << std::chrono::duration_cast<std::chrono::nanoseconds>(end-start).count() << "ns ItPowDub Total\n";

    start = std::chrono::high_resolution_clock::now();
    double result2 = RecursivePowerDouble(base1, exp1);
    end = std::chrono::high_resolution_clock::now();
    std::cout << std::chrono::duration_cast<std::chrono::nanoseconds>(end-start).count() << "ns RecPowDub Total\n";




    // std::cout<<result1<<std::endl;
    // std::cout<<result2<<std::endl;
}

/*
    Double implementations
*/

double IterativePowerDouble (double base, int exponent){
    auto start1 = std::chrono::high_resolution_clock::now();
    
    auto duration = start1.time_since_epoch();
    auto nanoseconds2 = std::chrono::duration_cast<std::chrono::nanoseconds>(duration);

    //std::cout << "First time: " << nanoseconds2.count() << " nanoseconds since epoch" << std::endl;

    auto end1 = std::chrono::high_resolution_clock::now();

    
    double retVal = 1.0;
    for (int i = 0; i < exponent; i++) {
        retVal *= base;

    }

    end1 = std::chrono::high_resolution_clock::now();
    auto difference = std::chrono::duration_cast<std::chrono::nanoseconds>(end1 - start1);
    
    auto duration2 = end1.time_since_epoch();
    int value = duration2.count();
    int value2 = duration.count();

    auto nanoseconds = std::chrono::duration_cast<std::chrono::nanoseconds>(duration2);
    


    //std::cout << "Second time: " << nanoseconds.count() << " nanoseconds since epoch" << std::endl;

    int nano = std::chrono::duration_cast<std::chrono::nanoseconds>(end1 - start1).count();
    // 1737069490
    // 1737069502
    int valuediff = value - value2;
    std::cout << valuediff << "ns ItDoub2\n";
    std::cout << nano << "ns ItDoub2\n";
    std::cout << difference.count() << "ns ItDoub2\n";
    return retVal;
}

double RecursivePowerDouble (double base, int exponent){
    auto start1 = std::chrono::high_resolution_clock::now();
    double retVal = 1.0;
    if (exponent < 0){
        return 1.0 / RecursivePowerDouble(base, -exponent);
    }   

    else {
        for (int i=0; i<exponent; i++)
        retVal *= base;
    }
    auto end1 = std::chrono::high_resolution_clock::now();


    int nano = std::chrono::duration_cast<std::chrono::nanoseconds>(end1 - start1).count();
    std::cout << nano << "ns RecDoub\n";

    return retVal;
}

/*
    Integer implementations
*/

int IterativePowerInt(int base, int exponent){
    
    int retVal = 1;
    for (int i = 0; i < exponent; i++) {
        retVal *= base;
    }
    
    return retVal;
}

int RecursivePowerInt (int base, int exponent){
    
    int retVal = 1;
    if (exponent < 0){
        return 1.0 / RecursivePowerInt(base, -exponent);
    }   

    else {
        for (int i=0; i<exponent; i++)
        retVal *= base;
    }
    
    return retVal;
}


