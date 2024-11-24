package org.graceliying.snippets.datatype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBufferAndStringBuilderExampleTest {
    @Test
    public void testStringBufferAndStringBuilder() {
        StringBufferAndStringBuilderExample example = new StringBufferAndStringBuilderExample();

        // Demonstrate StringBuffer
        System.out.println("Demonstrating StringBuffer:");
        example.demonstrateStringBuffer();

        // Demonstrate StringBuilder
        System.out.println("Demonstrating StringBuilder:");
        example.demonstrateStringBuilder();

        System.out.println("All StringBuffer and StringBuilder examples executed successfully!");
    }

}
