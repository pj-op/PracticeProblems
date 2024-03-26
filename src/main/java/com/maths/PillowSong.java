package com.maths;

public class PillowSong {
    public static void main(String[] args) {
        int numOfPeople = 5;
        int songTime = 7;
        System.out.println(foundThePillowHolder(numOfPeople, songTime));
    }

    private static int foundThePillowHolder(int numOfPeople, int t) {
        int res = 1;
        int step = 1;
        while (t > 0) {
            res = res + step;
            if (res == numOfPeople) step = -1;
            if (res == 1) step = 1;
            t--;
        }
        return res;
    }
}
