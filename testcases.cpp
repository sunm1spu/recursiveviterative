#include <iostream>
#include <chrono>

double IterativePowerDouble(double base, int exponent);
double RecursivePowerDouble(double base, int exponent);
int IterativePowerInt(int base, int exponent);
int RecursivePowerInt(int base, int exponent);


int main() {
    double base1 = 5.0;
    int exp1 = 6; 

    auto start = std::chrono::high_resolution_clock::now();
    double result1 = IterativePowerDouble(base1, exp1);
    auto end = std::chrono::high_resolution_clock::now();

    std::cout << std::chrono::duration_cast<std::chrono::nanoseconds>(end-start).count() << "ns\n";


    double result2 = RecursivePowerDouble(base1, exp1);
}

/*
    Double implementations
*/

double IterativePowerDouble (double base, int exponent){

    double retVal = 1.0;
    for (int i = 0; i < exponent; i++) {
        retVal *= base;
    }
    
    return retVal;
}

double RecursivePowerDouble (double base, int exponent){
    
    double retVal = 1.0;
    if (exponent < 0){
        return 1.0 / RecursivePowerDouble(base, -exponent);
    }   

    else {
        for (int i=0; i<exponent; i++)
        retVal *= base;
    }
    
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

