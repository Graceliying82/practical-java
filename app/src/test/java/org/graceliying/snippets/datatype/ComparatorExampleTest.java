package org.graceliying.snippets.datatype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorExampleTest {
    ComparatorExample comparatorExample = new ComparatorExample();
    @Test void testComparatorExample() {
        comparatorExample.sortStringsWithComparator();
        comparatorExample.sortCustomObjectsWithComparator();
        comparatorExample.sort2DArrayWithComparator();
        comparatorExample.sortWithMultipleCriteria();
    }

}
