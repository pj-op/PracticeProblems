package com.concepts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> flattenList;
    int count = 0;

    public NestedIterator(List<?> nestedList) {
        flattenList = new ArrayList<>();
        for (Object nest : nestedList) {
            util(nest);
        }
    }

    @Override
    public Integer next() {
        return flattenList.get(count++);
    }

    @Override
    public boolean hasNext() {
        return count < flattenList.size();
    }

    private void util(Object nested) {
//        if (nested.isInteger()) flattenList.add(nested.getInteger());
//        else {
//            for (NestedInteger nest : nested.getList()) {
//                util(nest);
//            }
//        }
    }
}
