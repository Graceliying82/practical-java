package org.graceliying.snippets.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the use of boxing and unboxing with generic types in Java.
 * <p>
 * This class provides examples of summing up integers in a list and adding
 * an element to a list using boxing and unboxing of {@code int} to {@code Integer}.
 */
public class BoxingAndUnboxing {

    /**
     * Calculates the sum of integers in the given list.
     * <p>
     * This method iterates through the list of integers, unboxing each {@code Integer}
     * into a primitive {@code int} to perform the summation.
     *
     * @param ints the list of integers to be summed
     * @return the total sum of integers in the list
     * @throws NullPointerException if the input list is null
     */
    public int sum(List<Integer> ints) {
        int i = 0;
        for (int n : ints) {
            i += n;
        }
        return i;
    }

    /**
     * Joins a given integer to a copy of the provided list of integers.
     * <p>
     * This method creates a new list by copying the elements of the input list
     * and adds the given integer to it using boxing of the primitive {@code int}
     * into an {@code Integer}.
     *
     * @param listA the list of integers to be copied and modified
     * @param s the integer to be added to the new list
     * @return a new list containing all elements of {@code listA} with {@code s} appended
     * @throws NullPointerException if {@code listA} is null
     */
    public List<Integer> join(List<Integer> listA, int s) {
        List<Integer> joinedList = new ArrayList<>(listA);
        joinedList.add(s);
        return joinedList;
    }
}
