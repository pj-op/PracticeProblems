package com.strings;

public class BullsAndCows {
    public static void main(String[] args) {
//        String secret = "1807", guess = "7810";
//        String secret = "1123", guess = "0111";
//        String secret = "11", guess = "01";
        String secret = "1122", guess = "0001";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int numOfBulls = 0;
        int numOfCows = 0;
        int[] secCountFeq = new int[10];
        int[] guessCountFeq = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                numOfBulls++;
            } else {
                secCountFeq[secret.charAt(i) - '0']++;
                guessCountFeq[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < secCountFeq.length; i++) {
            numOfCows += Math.min(secCountFeq[i], guessCountFeq[i]);
        }
        return numOfBulls + "A" + numOfCows + "B";
    }
}
