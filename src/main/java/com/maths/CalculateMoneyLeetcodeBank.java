package com.maths;

public class CalculateMoneyLeetcodeBank {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(totalMoney(n));
    }

    private static int totalMoney(int n) {
        int ans = 0;
        int div = n / 7;
        int rem = n % 7;
        int totalWeekDeposit = 28;
        while (div > 0) {
            ans += totalWeekDeposit;
            totalWeekDeposit += 7;
            div--;
        }
        div = n / 7;
        while (rem > 0) {
            div += 1;
            ans += div;
            rem--;
        }
        return ans;
    }
}
