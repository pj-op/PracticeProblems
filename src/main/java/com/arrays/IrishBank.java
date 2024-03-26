package com.arrays;

/*
PROBLEM
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station
to its next (i + 1)th station.
You begin the journey with an empty tank at one of the gas stations. Given two integer arrays gas and cost,
return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
otherwise return -1.
If there exists a solution, it is guaranteed to be unique

Example 1: Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2] Output: 3
Explanation: Start at station 3 (index 3) and fill up with 4 unit of gas.
Your tank = 0 + 4 = 4 Travel to station 4.
Your tank = 4 - 1 + 5 = 8 Travel to station 0.
Your tank = 8 - 2 + 1 = 7 Travel to station 1.
Your tank = 7 - 3 + 2 = 6 Travel to station 2.
Your tank = 6 - 4 + 3 = 5 Travel to station 3.
The cost is 5. Your gas is just enough to travel back to station 3. Therefore, return 3 as the starting index.

Example 2: Input: gas = [2,3,4], cost = [3,4,3] Output: -1
Explanation: You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas.
Your tank = 0 + 4 = 4 Travel to station 0.
Your tank = 4 - 3 + 2 = 3 Travel to station 1.
Your tank = 3 - 3 + 3 = 3 You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IrishBank {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
//        int [] gas = {2,3,4}, cost = {3,4,3};

//        System.out.println(getStation(gas, cost));
        int tank = 0;

       /* while (!queue.isEmpty()) {
            GPair source = queue.poll();
            int stationId = source.getStationId();
            int node = source.getGas();
            int costNode = source.getCost();

            tank = tank + node;

            if (tank >= costNode) {
                if (!visited[stationId]) {
                    visited[stationId] = true;
                    tank = tank - costNode + gas[stationId];
                } else {
                    System.out.println(stationId);
                    break;
                }
            } else {
                System.out.println();
            }*/

//        getStationByQueue(gas, cost);

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0, tank = 0, total = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
            total += gas[i] - cost[i];
        }
        return total < 0 ? -1 : start;
    }

    private static int getStationByQueue(int[] gas, int[] cost) {


        return -1;
    }

    private static int getStation(int[] gas, int[] cost) {
        int result = -1;
        int tankVolume = 0;
        boolean[] visited = new boolean[gas.length];

        for (int i = 0; i < gas.length; i++) {
            int startStation = i;
            tankVolume = tankVolume + gas[i];
            for (int j = 0; j < gas.length; j++) {
                int currTankVol = tankVolume + cost[j];
                if (currTankVol >= cost[j]) {
                    if (!visited[j]) {
                        visited[i] = true;
                        currTankVol = tankVolume - cost[j];
                    } else {
                        return i;
                    }
                } else {
                    break;
                }
            }
            tankVolume = 0;
            Arrays.fill(visited, false);
        }


        return result;
    }
}

@Data
@AllArgsConstructor
class GPair {
    int stationId;
    int gas;
    int cost;
}