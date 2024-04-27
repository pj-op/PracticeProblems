package com.new_problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStreamingAPI {


    public static void main(String[] args) {

        List<RawSignal> rawSignals = Arrays.asList(new RawSignal("vinSignal-1"), new RawSignal("vinSignal-2"), new RawSignal("vinSignal-3"));
        List<RawSignal> rawSignals2 = Arrays.asList(new RawSignal("vinSignal-11"), new RawSignal("vinSignal-22"), new RawSignal("vinSignal-33"));

        List<MainSignal> mainSignals = Arrays.asList(new MainSignal("SGN-1", rawSignals), new MainSignal("SGN-2", rawSignals2));

        Map<String, RawSignal> resultMap = new LinkedHashMap<>();

        mainSignals.forEach(mainSignal -> mainSignal.getRawSignals().forEach(rawSignal -> resultMap.put(mainSignal.getSignalId().concat("<->" + rawSignal.getVin()), rawSignal)));

//        System.out.println(resultMap);

        System.out.println(IntStream.rangeClosed(2, 1000).filter(x -> IntStream.rangeClosed(2, x / 2).noneMatch(y -> x % y == 0)).boxed().map(String::valueOf).collect(Collectors.joining(",")));

        /*
        Multiplying Strings
         */

        System.out.println(multiplyStrings("6300", "900"));


    }

    private static String multiplyStrings(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int result[] = new int[l1 + l2];

        if (s1.length() == 0 || s2.length() == 0) {
            return "0";
        }

        int i = l1 - 1;
        int pf = 0;
        while (i >= 0) {
            int iVal = s1.charAt(i) - '0';
            i--;

            int carry = 0;
            int j = l2 - 1;
            int k = result.length - 1 - pf;

            while (j >= 0 || carry != 0) {
                int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + carry + result[k];
                carry = prod / 10;
                result[k] = prod % 10;
                k--;
            }
            pf++;
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int a : result) {
            if (a == 0 && !flag) {
            } else {
                flag = true;
                sb.append(a);
            }
        }

        return sb.toString();
    }


}
