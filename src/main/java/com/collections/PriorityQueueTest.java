package com.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

public class PriorityQueueTest {
    public static void main(String[] args) {
        String s1 = null;
        System.out.println(StringUtils.hasLength(s1));
    }
}

@Data
@AllArgsConstructor
class PrNode {
    int node;
    int distance;
}