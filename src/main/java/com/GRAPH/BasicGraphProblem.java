package com.GRAPH;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BasicGraphProblem {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        IRB irb = new IRB(gas.length);
        irb.addDirectedEdge(0, 1);
        irb.addDirectedEdge(1, 2);
        irb.addDirectedEdge(2, 3);
        irb.addDirectedEdge(3, 4);
        irb.addDirectedEdge(4, 0);


        boolean[] visited = new boolean[gas.length];

        for (int i = 0; i < gas.length; i++) {
            if (!visited[i]) {
                System.out.println(getStationId(gas, cost, i, visited, irb.adjList));
            }
        }


    }

    private static int getStationId(int[] gas, int[] cost, int stationId, boolean[] visited, List<Integer>[] adjList) {
        Queue<NCS> queue = new LinkedList<>();
        queue.add(new NCS(gas[stationId], cost[stationId], stationId));
        visited[stationId] = true;
        int tank = cost[stationId];

        while (!queue.isEmpty()) {
            NCS currEle = queue.poll();
            int gasNode = currEle.getGasNode();
            int costNode = currEle.getCostNode();
            int station = currEle.getStationId();

            for (int neigh : adjList[station]) {
                int currGasNode = gas[neigh];
                int currCostNode = cost[neigh];
                int currStation = neigh;

                if (tank >= currCostNode) {
                    if (!visited[currStation]) {
                        visited[currCostNode] = true;
                        tank = tank - costNode + currGasNode;
                    } else {
                        return stationId;
                    }
                } else {
                    continue;
                }
            }
        }
        return -1;
    }
}

class IRB {
    int numOfVertex;
    List<Integer>[] adjList;

    IRB(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        this.adjList = new LinkedList[numOfVertex];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addDirectedEdge(int source, int destination) {
        adjList[source].add(destination);
    }
}

@Data
@AllArgsConstructor
class NCS {
    int gasNode;
    int costNode;
    int stationId;
}