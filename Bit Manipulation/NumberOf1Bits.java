public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 29; // Example input
        int result = hammingWeight(n);
        System.out.println("Number of set bits: " + result);
    }
}


//Write a function that takes the binary representation of a positive integer and returns the number of 
//set bits
// it has (also known as the Hamming weight).