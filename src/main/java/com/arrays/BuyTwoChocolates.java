package com.arrays;

public class BuyTwoChocolates {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 2, 12, 43, 43, 5};
        int money = 7;
        System.out.println(buyChocoOptimal(prices, money));
    }

    private static int buyChocoOptimal(int[] prices, int money) {
        int max = prices[0];
        int secMax = -1;

        for (int i = 1; i < prices.length; i++) {
            if (max < prices[i]) {
                secMax = max;
                max = prices[i];
            } else if (secMax < prices[i]) {
                secMax = prices[i];
            }
        }
        int spent = max + secMax;

        return spent <= money ? (money - spent) : money;

    }

    public static int buyChoco(int[] prices, int money) {
        int rem = money - prices[0];
        int count = 1;
        for (int i = 1; i < prices.length; i++) {
            if (count < 2 && rem > 0 && prices[i] <= rem) {
                rem -= prices[i];
                count++;
            }
        }
        return count == 2 ? rem : money;
    }
}
