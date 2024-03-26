package com.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLongestSpecialSubStringThriceI {
    public static void main(String[] args) {
        String s =
//                "aaaa";
                "abcaba";
        System.out.println(maximumLength(s));
    }

    public static int maximumLength(String s) {
        int i = 0;
        int j = 1;
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();

        while (i < n) {
            while (j <= n) {
                boolean flag = false;
                String str = s.substring(i, j);
                for (int k = 0; k + 1 < str.length(); k++) {
                    if (str.charAt(k) != str.charAt(k + 1)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
                j++;
            }
            j = i + 1;
            i++;
        }
        System.out.println(map);

        int ans = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                ans = Math.max(ans, entry.getKey().length());
            }
        }
        return ans;
    }
}
