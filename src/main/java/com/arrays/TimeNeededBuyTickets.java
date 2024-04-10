package com.arrays;

public class TimeNeededBuyTickets {
    public static void main(String[] args) {
        int[] tickets = {2,3,2};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    private static int timeRequiredToBuy(int[] tickets, int k) {
        int idx = 0;
        int count = 0;
        int n = tickets.length;

        while (tickets[k] != 0) {
            if (tickets[idx] != 0) {
                tickets[idx] -= 1;
                count++;
            }
            idx++;
            if (idx == n) {
                idx = 0;
            }
        }


        return count;
    }

}
