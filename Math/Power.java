public class Power {

    public static double myPow(double x, int n) {
        // Handle negative exponent case
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        return powHelper(x, n);
    }
    
    private static double powHelper(double x, int n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }
        
        // Recursive case for even n
        double half = powHelper(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else { // Recursive case for odd n
            return half * half * x;
        }
    }
    public static void main(String[] args) {
        double x1 = 2.0;
        int n1 = 10;
        System.out.println(x1 + " raised to the power " + n1 + " is: " + myPow(x1, n1)); // Output: 1024.0
        
        double x2 = 2.1;
        int n2 = 3;
        System.out.println(x2 + " raised to the power " + n2 + " is: " + myPow(x2, n2)); // Output: 9.261000000000001
        
        double x3 = 2.0;
        int n3 = -2;
        System.out.println(x3 + " raised to the power " + n3 + " is: " + myPow(x3, n3)); // Output: 0.25
    }
}


//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).