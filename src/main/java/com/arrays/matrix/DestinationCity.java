package com.arrays.matrix;

import java.util.*;

public class DestinationCity {
    public static void main(String[] args) {
        List<List<String>> paths =
//                Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sao Paulo"));
                Arrays.asList(Arrays.asList("B", "C"), Arrays.asList("D", "B"), Arrays.asList("C", "A"));
        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> locations = new HashSet<>();
        for (List<String> path : paths) {
            locations.add(path.get(0));
        }
        for (List<String> path : paths) {
            if(!locations.contains(path.get(1))) return path.get(1);
        }
        return null;
    }
}
