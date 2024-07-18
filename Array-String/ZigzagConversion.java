public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        // Create an array of StringBuilder to hold strings for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse through the input string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // If we are at the first or the last row, change direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into one string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();

        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println(solution.convert(s1, numRows1));  // Output: "PAHNAPLSIIGYIR"

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println(solution.convert(s2, numRows2));  // Output: "PINALSIGYAHRPI"

        String s3 = "A";
        int numRows3 = 1;
        System.out.println(solution.convert(s3, numRows3));  // Output: "A"
    }
}


//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
//(you may want to display this pattern in a fixed font for better legibility)

//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"

//Write the code that will take a string and make this conversion given a number of rows:

//string convert(string s, int numRows);