package com.arrays.matrix;

import java.util.Arrays;

public class NumberLaserBeamsInBank {
    public static void main(String[] args) {
        String[] bank = {
                "011001",
                "000000",
                "010100",
                "001000"
        };
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int result = 0;
        int prevDeviceCount = 0;

        for (String floor : bank) {
            int currCountOfDevice = 0;
            for (char c : floor.toCharArray()) {
                if (c == '1') {
                    currCountOfDevice++;
                }
            }
            result += (currCountOfDevice * prevDeviceCount);
            if (currCountOfDevice != 0) {
                prevDeviceCount = currCountOfDevice;
            }
        }
        return result;
    }
}
