// Double implementations
double IterativePower(double base, int exponent){
    
    double retVal = 1.0;
    for (int i = 0; i < exponent; i++) {
        retVal *= base;
    }
    
    return retVal;
}

double RecursivePower (double base, int exponent){
    
    double retVal = 1.0;
    if (exponent < 0){
        return 1.0 / RecursivePower(base, -exponent);
    }   

    else {
        for (int i=0; i<exponent; i++)
        retVal *= base;
    }
    
    return retVal;
}

// Integer implementations

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
        return 1.0 / RecursivePower(base, -exponent);
    }   

    else {
        for (int i=0; i<exponent; i++)
        retVal *= base;
    }
    
    return retVal;
}

int main(int argc, char **argv) {
    double base1 = 5.0;
    int exp1 = 6; 

    double result1 = IterativePower(base1, exp1);
    double result2 = RecursivePower(base1, exp1);
}