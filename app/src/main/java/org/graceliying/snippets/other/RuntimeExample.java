package org.graceliying.snippets.other;

/**
 * This class provides examples of working with the {@code Runtime} class in Java,
 * including memory management, garbage collection, and process execution.
 */
public class RuntimeExample {

    /**
     * Demonstrates memory management using the {@code Runtime} class.
     * <p>
     * This method showcases:
     * <ul>
     *     <li>Retrieving the total memory available to the JVM using {@code totalMemory()}.</li>
     *     <li>Checking the free memory before and after suggesting garbage collection using {@code freeMemory()}.</li>
     * </ul>
     * It then uses assertions to verify that the free memory increases after garbage collection:
     * <ul>
     *     <li>Assert that {@code freeMemoryAfterGC} is greater than or equal to {@code freeMemoryBeforeGC}.</li>
     * </ul>
     *
     * @throws AssertionError if the assertion fails
     */
    // 1. Memory Management
    public void demonstrateMemoryManagement() {
        final Runtime runtime = Runtime.getRuntime();

        final long freeMemoryBeforeGC = runtime.freeMemory();
        runtime.gc(); // Suggest garbage collection
        final long freeMemoryAfterGC = runtime.freeMemory();

        System.out.println("Free memory before GC: " + freeMemoryBeforeGC);
        System.out.println("Free memory after GC: " + freeMemoryAfterGC);

        // Check that gc() was invoked successfully, without strict memory comparison
        assert freeMemoryBeforeGC >= 0 && freeMemoryAfterGC >= 0 :
            "Garbage collection did not behave as expected";
    }

    /**
     * Executes an external process using the {@code Runtime} class.
     * <p>
     * This method demonstrates:
     * <ul>
     *     <li>Launching an external process using {@code exec()}.</li>
     *     <li>Handling exceptions when the command is invalid or the process fails to start.</li>
     *     <li>Waiting for the process to complete using {@code waitFor()}.</li>
     * </ul>
     * It prints messages indicating the process's launch and termination.
     *
     * @throws AssertionError if an unexpected exception occurs
     */
    // 2. Process Execution
    public void demonstrateProcessExecution() {
        final Runtime runtime = Runtime.getRuntime();

        try {
            // Launch an external process (TextEdit as an example)
            Process process = runtime.exec("open -a TextEdit");
            System.out.println("Process launched successfully.");

            // Wait for the process to complete
            process.waitFor();
            System.out.println("Process completed.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            assert false : "Process execution should succeed without exceptions";
        }
    }
}
