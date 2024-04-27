package com.dp;

import java.util.Arrays;

public class WalkingRobotNew {

	public static void main(String[] args) {
		String command = "L";
		System.out.println(Arrays.toString(walkRobot(command)));
//		walkRobot(command);
	}

	public static int[] walkRobot(String command) {
		char[] charCommand = command.toCharArray();

		int[] inputXY = new int[2];

		inputXY[0] = 0;
		inputXY[1] = 0;

		for (char c : charCommand) {
			if (c == 'U')
				inputXY[1] += 1;
			else if (c == 'D')
				inputXY[1] -= 1;
			else if (c == 'L')
				inputXY[0] -= 1;
			else if (c == 'R')
				inputXY[0] += 1;
		}

		return inputXY;
	}

}
