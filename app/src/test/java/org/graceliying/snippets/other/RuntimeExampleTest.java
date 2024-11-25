package org.graceliying.snippets.other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuntimeExampleTest {
    private RuntimeExample example = new RuntimeExample();
    @Test
    public void testRuntimeExample() {

        // Demonstrate memory management
        example.demonstrateMemoryManagement();

        // Demonstrate process execution
        example.demonstrateProcessExecution();
    }



}
