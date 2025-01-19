
public class Main {
    /*
        Double implementation
     */
    public static double recursivePowerDouble(double base, int exponent) {
        long start = System.nanoTime();
        
        double retValue = 1.0;
        if (exponent < 0){

            return 1.0 / iterativePowerDouble(base, -exponent);
        }   
        double result = recursivePowerDoubleHelper(base, exponent, base);

        long end = System.nanoTime();
        long duration = end - start;

        System.out.println("Recursion time " + duration + "ns");
        return result;
    }

    public static double recursivePowerDoubleHelper(double base, int exponent, double result) {
        
        
        if (exponent > 1) {
            return recursivePowerDoubleHelper(base, exponent - 1, result * base);    
        }

        return result;

    }

    public static double iterativePowerDouble(double base, int exponent) {
        long start = System.nanoTime();
        
        double retValue = 1.0;
         if (exponent < 0){

            return 1.0 / iterativePowerDouble(base, -exponent);
        }   

        for (int i = 0; i < exponent; i++) {
            retValue *= base;
        }

        long end = System.nanoTime();

        long execTime = (end - start);
        
        System.out.println("Iterative time " + execTime + "ns");
        return retValue;
    }


    /*
        Integer implementation
     */

     public static int recursivePowerInt(int base, int exponent) {
        long start = System.nanoTime();
        
        if (exponent < 0){

            return 1 / recursivePowerInt(base, -exponent);
        }   
        int result = recursivePowerIntHelper(base, exponent, base);

        long end = System.nanoTime();
        long duration = end - start;

        System.out.println("Recursion time " + duration + "ns");
        return result;
    }

    public static int recursivePowerIntHelper(int base, int exponent, int result) {
        
        
        if (exponent > 1) {
            return recursivePowerIntHelper(base, exponent - 1, result * base);    
        }

        return result;

    }

    public static int iterativePowerInt(int base, int exponent) {
        long start = System.nanoTime();
        
        int retValue = 1;
         if (exponent < 0){

            return 1 / iterativePowerInt(base, -exponent);
        }   

        for (int i = 0; i < exponent; i++) {
            retValue *= base;
        }

        long end = System.nanoTime();

        long execTime = (end - start);
        
        System.out.println("Iterative time " + execTime + "ns");
        return retValue;
    }


    public static void main(String[] args) {
        double base1 = 5.0;
        int base2 = 5;

        int exponent1 = 200;

        
        System.out.println("============== DOUBLE IMPLEMENTATION ==============");
        double result = iterativePowerDouble(base1, exponent1);
        double result2 = recursivePowerDouble(base1, exponent1);

        System.out.println("Iterative result " + result);
        System.out.println("Recursive result " + result2);

        System.out.println("============== INTEGER IMPLEMENTATION ==============");
        int result3 = iterativePowerInt(base2, exponent1);
        int result4 = recursivePowerInt(base2, exponent1);
        
        System.out.println("Iterative result " + result3);
        System.out.println("Recursive result " + result4);
    }
}