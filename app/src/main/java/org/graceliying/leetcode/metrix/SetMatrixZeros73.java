package org.graceliying.leetcode.metrix;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.HashSet;
import java.util.Set;

/**
 * Class containing two solutions for setting matrix zeros.
 *
 * Solution 1: Uses HashSet to store zero positions (extra space).
 * Solution 2: Uses the first row and first column as markers (in-place, optimal).
 */
public class SetMatrixZeros73 {

    /**
     * Solution 1: Uses HashSet to store row and column indexes that contain zeros.
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n) (extra space for row and column sets)
     *
     * @param matrix The input matrix to modify in-place.
     */
    public static void setZeroesWithHashSet(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // First pass: Identify rows and columns that should be zeroed
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Second pass: Set rows to zero
        for (int row : rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }

        // Third pass: Set columns to zero
        for (int col : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    /**
     * Solution 2: Uses the first row and first column as markers to track zero positions.
     * Time Complexity: O(m * n)
     * Space Complexity: O(1) (in-place modification)
     *
     * @param matrix The input matrix to modify in-place.
     */
    public static void setZeroesInPlace(int[][] matrix) {
        boolean zeroInFirstRow = false;
        boolean zeroInFirstColumn = false;

        int m = matrix.length;
        int n = matrix[0].length;

        // Check if first column has any zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroInFirstColumn = true;
                break;
            }
        }

        // Check if first row has any zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                zeroInFirstRow = true;
                break;
            }
        }

        // Use first row and first column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; // Mark column
                    matrix[i][0] = 0; // Mark row
                }
            }
        }

        // Zero out marked rows
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out marked columns
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (zeroInFirstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (zeroInFirstColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Helper method to print a matrix.
     *
     * @param matrix The matrix to print.
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Measures and prints CPU usage, execution time, and memory usage.
     *
     * @param startTime Start time in nanoseconds.
     * @param startMemory Used memory before execution.
     */
    private static void printPerformanceMetrics(long startTime, long startMemory) {
        long endTime = System.nanoTime();
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double cpuUsage = getCpuUsage();

        System.out.printf("Execution Time: %.6f ms\n", (endTime - startTime) / 1e6);
        System.out.printf("Memory Used: %.2f KB\n", (endMemory - startMemory) / 1024.0);
        System.out.printf("CPU Usage: %.2f%%\n", cpuUsage);
        System.out.println("----------------------------------------");
    }

    /**
     * Returns the CPU usage percentage.
     */
    private static double getCpuUsage() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        return osBean.getSystemLoadAverage() * 100;
    }

    /**
     * Main method to test both solutions with performance metrics.
     */
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3, 4, 5},
            {6, 0, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 0, 20},
            {21, 22, 23, 24, 25}
        };

        int[][] matrix2 = {
            {1, 2, 3, 4, 5},
            {6, 0, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 0, 20},
            {21, 22, 23, 24, 25}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix1);

        // Test HashSet Solution
        System.out.println("Using HashSet Solution:");
        long startTime = System.nanoTime();
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        setZeroesWithHashSet(matrix1);
        printMatrix(matrix1);
        printPerformanceMetrics(startTime, startMemory);

        // Test In-Place Solution
        System.out.println("Using In-Place Solution:");
        startTime = System.nanoTime();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        setZeroesInPlace(matrix2);
        printMatrix(matrix2);
        printPerformanceMetrics(startTime, startMemory);
    }
}
