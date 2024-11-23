package org.graceliying.snippets.datatype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortExampleTest {
    ArraySortExample arraySortExample = new ArraySortExample();
    @Test
    void TestArraySortExample() {
        arraySortExample.sortPrimitiveArray();
        arraySortExample.sortObjectArray();
        arraySortExample.customSortObjectArray();
        arraySortExample.sort2DArray();
    }
}
