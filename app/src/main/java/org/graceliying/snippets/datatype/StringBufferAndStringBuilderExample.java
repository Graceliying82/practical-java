package org.graceliying.snippets.datatype;


import lombok.extern.slf4j.Slf4j;

/**
 * This class provides examples of working with StringBuffer and StringBuilder in Java.
 * <p>
 * Both {@code StringBuffer} and {@code StringBuilder} are mutable classes used to modify strings efficiently.
 * Key differences:
 * <ul>
 *     <li>{@code StringBuffer} is thread-safe and synchronized, making it suitable for multi-threaded environments.</li>
 *     <li>{@code StringBuilder} is not synchronized, offering better performance in single-threaded applications.</li>
 * </ul>
 */
@Slf4j
public class StringBufferAndStringBuilderExample {
    /**
     * Demonstrates basic operations with StringBuffer, including appending, inserting,
     * replacing, and reversing.
     */
    public void demonstrateStringBuffer() {
        StringBuffer buffer = new StringBuffer("Hello");

        // append() - Adding text at the end
        buffer.append(", World!");
        assert buffer.toString().equals("Hello, World!") : "StringBuffer should now be 'Hello, World!'";

        // insert() - Adding text at a specific position
        buffer.insert(5, " Java");
        assert buffer.toString().equals("Hello Java, World!") : "StringBuffer should now be 'Hello Java, World!'";

        // replace() - Replacing text in a range
        buffer.replace(6, 10, "Kotlin");
        assert buffer.toString().equals("Hello Kotlin, World!") : "StringBuffer should now be 'Hello Kotlin, World!'";

        // reverse() - Reversing the entire content
        buffer.reverse();
        log.info(buffer.toString());
        assert buffer.toString().equals("!dlroW ,niltoK olleH") : "StringBuffer should now be reversed";


        // setLength() - Trimming or padding the buffer
        buffer.setLength(5);
        assert buffer.toString().equals("!dlro") : "StringBuffer should be truncated to '!dlro'";
    }

    /**
     * Demonstrates basic operations with StringBuilder, including appending, inserting,
     * deleting, and capacity management.
     */
    public void demonstrateStringBuilder() {
        StringBuilder builder = new StringBuilder("Java");

        // append() - Adding text at the end
        builder.append(" Programming");
        assert builder.toString().equals("Java Programming") : "StringBuilder should now be 'Java Programming'";

        // delete() - Removing text in a range
        builder.delete(5, 16);
        assert builder.toString().equals("Java ") : "StringBuilder should now be 'Java '";

        // insert() - Adding text at a specific position
        builder.insert(4, "Script");
        assert builder.toString().equals("JavaScript ") : "StringBuilder should now be 'JavaScript '";

        // reverse() - Reversing the entire content
        builder.reverse();
        assert builder.toString().equals(" tpircSavaJ") : "StringBuilder should now be reversed";

        // EnsureCapacity() - Ensuring minimum capacity
        builder.ensureCapacity(50);
        assert builder.capacity() >= 50 : "Capacity should be at least 50";
    }
}
