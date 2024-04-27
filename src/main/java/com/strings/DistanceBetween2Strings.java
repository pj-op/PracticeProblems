package com.strings;

public class DistanceBetween2Strings {

	public static void main(String[] args) {
		String docs = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";

		System.out.println(new DistanceBetween2Strings().getDistBetweenStrings(docs, "is", "a"));
	}

	public double getDistBetweenStrings(String docs, String one, String two) {

		double word1Dist = 0;
		double word2Dist = 0;
		double totalDistance = 0;

		String [] words = docs.split(" ");
		double minlenght = Double.MAX_VALUE;

		for (String word : words) {
			if (word.equals(one)) {
				word1Dist = totalDistance + word.length() / 2d;
			} else if (word.equals(two)) {
				word2Dist = totalDistance + word.length() / 2d;
			}
			if (word1Dist > 0 && word2Dist > 0) {
				double current = Math.abs(word1Dist - word2Dist);
				if (current < minlenght) {
					minlenght = current;
				}
			}
			totalDistance = totalDistance + word.length() + 1;
		}
		return minlenght;
	}
}
