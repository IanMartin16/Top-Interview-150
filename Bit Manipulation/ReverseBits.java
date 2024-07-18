public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit of n
            int bit = n & 1;
            // Shift the result left to make space for the next bit
            result = (result << 1) | bit;
            // Shift n right to process the next bit
            n >>= 1;
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 43261596; // Example input
        int result = reverseBits(n);
        System.out.println("Reversed bits: " + result);
    }
}


//Reverse bits of a given 32 bits unsigned integer.

//Note:

//Note that in some languages, such as Java, there is no unsigned integer type. In this case, 
//both input and output will be given as a signed integer type. They should not affect your implementation, 
//as the integer's internal binary representation is the same, whether it is signed or unsigned.
//In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, 
//the input represents the signed integer -3 and the output represents the signed integer -1073741825.