package com.GRAPH.graphpractice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.IntStream;

public class DijkstraExample {
    public static void main(String[] args) {
        int[][][] adjList = {
                //Test Case - 1
                /*
                {{1, 1}, {2, 6}},   //0
                {{2, 3}, {0, 1}},   //1
                {{1, 3}, {0, 6}}    //2
                */

                //Test Case - 26
                /*{{1, 9}}, {{0, 9}}*/

                //Test Case - 3
                {{}},
                {{2, 2}, {4, 1}},
                {{1, 2}, {3, 4}, {5, 5}},
                {{4, 3}, {2, 4}, {5, 1}},
                {{1, 1}, {3, 3}},
                {{2, 5}, {3, 1}}


        };
        int src = 2;
        int dst = 5;
        System.out.println(Arrays.toString(findShortestPathUsingPQDijkstra(adjList, src, dst)));
//        System.out.println(Arrays.toString(findShortestPathUsingSetDijkstra(adjList, src)));
    }

    private static int[] findShortestPathUsingSetDijkstra(int[][][] adjList, int src) {
        int[] dist = new int[adjList.length];
        IntStream.range(0, dist.length).forEach(i -> dist[i] = Integer.MAX_VALUE);
        dist[src] = 0;

        Set<Pair> ts = new TreeSet<>(Comparator.comparingInt(Pair::getDist));
        Pair pair = new Pair(src, dist[src]);
        ts.add(pair);
        Iterator<Pair> setIterator = ts.iterator();

        while (setIterator.hasNext()) {
            Pair currPair = setIterator.next();
            int currNode = currPair.getNode();
            int currDist = currPair.getDist();
            setIterator.remove();

            for (int[] neigh : adjList[currNode]) {
                int neighNode = neigh[0];
                int neighDist = neigh[1];
                if (dist[neighNode] > neighDist + currDist) {
                    if (dist[neighNode] != Integer.MAX_VALUE) setIterator.remove();
                    dist[neighNode] = neighDist + currDist;
                    ts.add(new Pair(neighNode, dist[neighNode]));
                }
            }

        }


        return dist;
    }

    private static int[] findShortestPathUsingPQDijkstra(int[][][] adjList, int src, int dst) {
        int[] dist = new int[adjList.length];
        int[] parent = new int[adjList.length];
        IntStream.range(0, parent.length).forEach(i -> parent[i] = i);
        IntStream.range(0, dist.length).forEach(i -> dist[i] = Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getDist));
        Pair pair = new Pair(src, dist[src]);
        pq.add(pair);

        while (!pq.isEmpty()) {
            Pair currPair = pq.poll();
            int currNode = currPair.getNode();
            int currDist = currPair.getDist();

            for (int[] neigh : adjList[currNode]) {
                int neighNode = neigh[0];
                int neighDist = neigh[1];

                if (dist[neighNode] > neighDist + currDist) {
                    dist[neighNode] = neighDist + currDist;
                    parent[neighNode] = currNode;
                    pq.add(new Pair(neighNode, dist[neighNode]));
                }
            }
        }

        System.out.println(Arrays.toString(parent));

        List<Integer> path = new ArrayList<>();

        while (parent[dst] != dst) {
            path.add(dst);
            dst = parent[dst];
        }
        path.add(src);

        Collections.reverse(path);
        System.out.println("Shortest Path: " + path);

        return dist;
    }
}

@Data
@AllArgsConstructor
class Pair {
    int node;
    int dist;
}