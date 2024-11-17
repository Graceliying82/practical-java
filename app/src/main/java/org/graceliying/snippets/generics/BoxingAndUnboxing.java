package org.graceliying.snippets.generics;

import java.util.ArrayList;
import java.util.List;

public class BoxingAndUnboxing {

    public int sum(List<Integer> ints) {
        int i = 0;
        for(int n: ints) {
            i += n;
        }
        return i;
    }

    public List<Integer> join(List<Integer> listA, int s) {
        List<Integer> joinedList = new ArrayList<>(listA);
        joinedList.add(s);
        return joinedList;
    }
}
