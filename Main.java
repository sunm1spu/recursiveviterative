import java.io.PrintWriter;

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
        double result = 0;
        try {
            result = recursivePowerDoubleHelper(base, exponent, base);
        } 
        catch (StackOverflowError e) {
            System.out.println("RPD ERROR: " + e);
        }

        long end = System.nanoTime();
        long duration = end - start;

        // System.out.println("Recursion time " + duration + "ns");
        return result;
    }

    public static double recursivePowerDoubleHelper(double base, int exponent, double result) {
        
        
        if (exponent > 1) {
            try {
                return recursivePowerDoubleHelper(base, exponent - 1, result * base);        
            } 
            
            catch (StackOverflowError e) {
                // System.out.println("ERROR IN RECURSION: " + e);
            }
            
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
        
        // System.out.println("Iterative time " + execTime + "ns");
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

    public static void printToFile(String output) {
        try (PrintWriter writer = new PrintWriter("tao.csv")){
            
            writer.println(output);
        } catch (Exception error) {

            System.err.println("ERROR PRINTING TO FILE: " + error.getMessage());
        }
    }


    public static int findMaxN(int function, int baseInteger, double baseDouble) {
        int i = 0;
        int max_value = Integer.MAX_VALUE;
        
        switch (function) {
            case 0:
                try {
                    // i < Integer.MAX_VALUE; i = max_value - (max_value - i) / 2)
                    while (max_value != i) {
                        System.out.println(i);
                        double result = iterativePowerDouble(baseDouble, i);
                        
                        // If we overshoot max, go down
                        if (result > Double.MAX_VALUE) {
                            max_value = i;
                            i = i / 2;
                        }
                        
                        // If we undershoot max, go up
                        else {
                            i = max_value - (max_value - i) / 2;
                        }

                        // System.out.println("Result: " + result);
                    }
                } 
                
                catch (Exception error) {
                    System.out.println("IPD MAX N FOUND");
                    return i;
                }
                return i - 1;
            case 1:
                try {
                        
                    while (max_value != i) {
                        System.out.println(i);
                        
                        double result = recursivePowerDouble(baseDouble, i);
                        
                        // If we overshoot max, go down
                        if (result > Double.MAX_VALUE) {
                            max_value = i;
                            i = i / 2;
                        }
                        
                        // If we undershoot max, go up
                        else {
                            i = max_value - (max_value - i) / 2;
                        }

                        // System.out.println("Result: " + result);
                    }
                } 
                
                catch (Exception error) {
                    System.out.println("RPD MAX N: " + i + ", " + error);
                    return i;
                }
                return i - 1;    

            case 2:
                try {
                    while (max_value != i) {
                        System.out.println(i);
                        int result = iterativePowerInt(baseInteger, i);
                        
                        // If we overshoot max, go down
                        if (result > Integer.MAX_VALUE) {
                            max_value = i;
                            i = i / 2;
                        }
                        
                        // If we undershoot max, go up
                        else {
                            i = max_value - (max_value - i) / 2;
                        }

                    }
                } 
                
                catch (Exception error) {
                    System.out.println("IPD MAX N FOUND");
                    return i;
                }
                return i;
                
            case 3:
                try {
                        
                    for (; i < Integer.MAX_VALUE; i = Integer.MAX_VALUE - (Integer.MAX_VALUE - i) / 2) {
                    
                        recursivePowerInt(baseInteger, i);
                    }
                } 
                
                catch (Exception error) {
                    System.out.println("IPD MAX N: " + i + ", " + error);
                    return i;
                }
                return i;

            default:
                throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        double baseDouble = 2.718281828459045091;
        int baseInteger = 1000003;
        
        int exponent1 = 2000;

        double resultIPD;
        double resultRPD;
        int resultIPI;
        int resultRPI;

        int maxN = 0;

        int[] maxArray = new int [4];
        for (int i = 0; i <= 1; i++) {
            maxN = findMaxN(i, baseInteger, baseDouble);
            maxArray[i] = (int)maxN;
        }

        System.out.println("MaxN 1: " + maxArray[0]);
        System.out.println("MaxN 2: " + maxArray[1]);

        double test2 = iterativePowerDouble(baseDouble, 709);

        // Max iterative double expt 709
        // double test2 = recursivePowerDouble(baseDouble, 50);
        System.out.println(test2);
        // System.out.println(Math.pow(baseDouble, 50));

        // System.out.println("============== DOUBLE IMPLEMENTATION ==============");
        // resultIPD = iterativePowerDouble(baseDouble, exponent1);
        // resultRPD = recursivePowerDouble(baseDouble, exponent1);

        // System.out.println("============== INTEGER IMPLEMENTATION ==============");
        // resultIPI = iterativePowerInt(baseInteger, exponent1);
        // resultRPI = recursivePowerInt(baseInteger, exponent1);
    }
}