package org.graceliying.algorithm.xor;

public class XORToGenerateAllCombinations {
    /**
     * This method generates and prints all possible binary strings of length 'n'.
     * Each binary string is made up of characters '0' and '1', representing all
     * combinations of 0s and 1s for a string of length n.
     *
     * The total number of binary strings for length n is 2^n, as each position
     * can be either '0' or '1', and there are n positions. Therefore, we need
     * to print all numbers from 0 to 2^n - 1, with each number represented
     * as a binary string of length n.
     *
     * The method uses bit manipulation (specifically, bit shifting) to generate
     * the binary numbers.
     *
     * @param n The length of the binary strings to be generated.
     */
    public void printAllCombinations(int n) {
        // Total number of combinations is 2^n. This is calculated by shifting 1 left by n positions.
        int totalCombinations = (1 << n); // This is equivalent to 2^n

        // We need to iterate from 0 to 2^n - 1 (totalCombinations - 1)
        // Each iteration will represent a unique binary string.
        for (int i = 0; i < totalCombinations; i++) {
            // StringBuilder to accumulate the binary representation of the current number
            StringBuilder sb = new StringBuilder();

            // Generate the binary representation of the current number 'i'
            // We start from the most significant bit and go towards the least significant bit.
            for (int j = n - 1; j >= 0; j--) {
                // Shift the number 'i' to the right by 'j' positions
                // This will bring the bit at the 'j'-th position to the least significant bit (rightmost)
                // Then we use bitwise AND with 1 (i.e., (i >> j) & 1) to extract this bit.
                sb.append((i >> j) & 1); // Append '0' or '1' to the StringBuilder
            }

            // Print the binary string of length 'n'
            System.out.println(sb.toString());
        }
    }

    // Main method for testing the printAllCombinations function
    public static void main(String[] args) {
        XORToGenerateAllCombinations solution = new XORToGenerateAllCombinations();
        solution.printAllCombinations(3); // Example: print all combinations of a binary string of length 3
    }

}
