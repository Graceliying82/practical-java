package org.graceliying.snippets.datatype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringExampleTest {

    @Test
    public void testStringExample() {
        StringExample example = new StringExample();
        example.stringBasics();
        example.stringComparisons();
        example.stringManipulations();
        example.stringCombining();
        example.stringChecksAndConversions();

        System.out.println("All String examples executed successfully!");
    }

}
