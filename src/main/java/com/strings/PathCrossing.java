package com.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing {
    public static void main(String[] args) {
        String path = "NSN";
        System.out.println(isPathCrossing(path));
    }

    public static boolean isPathCrossing(String path) {

        Map<Character, XYPair> map = new HashMap<>();
        map.put('N', new XYPair(0, 1));
        map.put('S', new XYPair(0, -1));
        map.put('E', new XYPair(1, 0));
        map.put('W', new XYPair(-1, 0));

        Set<XYPair> visitedCords = new HashSet<>();
        visitedCords.add(new XYPair(0, 0));

        int x = 0;
        int y = 0;

        for (char c : path.toCharArray()) {
            XYPair incomingCords = map.get(c);
            int dx = incomingCords.x;
            int dy = incomingCords.y;
            x += dx;
            y += dy;

            XYPair cord = new XYPair(x,y);
            if (visitedCords.contains(cord)) return true;
            else visitedCords.add(cord);
        }
        return false;
    }
}

class XYPair {
    int x;
    int y;

    public XYPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XYPair xyPair = (XYPair) o;

        if (x != xyPair.x) return false;
        return y == xyPair.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "XYPair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}