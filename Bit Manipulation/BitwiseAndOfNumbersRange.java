public class BitwiseAndOfNumbersRange {

    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return left & right;
    }
    public static void main(String[] args) {
        int left = 5; // Example input
        int right = 7; // Example input
        int result = rangeBitwiseAnd(left, right);
        System.out.println("Bitwise AND of range [" + left + ", " + right + "] is: " + result); // Output: 4
    }
}


//Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.