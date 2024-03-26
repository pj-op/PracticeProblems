package com.GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BombDetonation {
    /*public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] adjList = new List[n];
        IntStream.range(0, adjList.length).forEach(i -> adjList[i] = new ArrayList<>());

        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    long x2 = bombs[j][0];
                    long y2 = bombs[j][1];
                    long r2 = bombs[j][2];
                    long p = r1;
                    long dist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                    if (dist <= p * p) {
                        adjList[i].add(j);
                    }
                }
            }
        }
        int[] visited = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            dfsMaxDetonation(i, cnt, visited, adjList);
            ans = Math.max(ans, cnt);
            Arrays.fill(visited, 0);
        }
        return ans;
    }

    private static void dfsMaxDetonation(int src, int cnt, int[] visited, List<Integer>[] adjList) {
        visited[src] = 1;
        cnt++;
        for (int neigh : adjList[src]) {
            if (visited[neigh] != 1) {
                dfsMaxDetonation(neigh, cnt, visited, adjList);
            }
        }
    }
*/
    static int count = 0;

    public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            dfs(i, new boolean[n], bombs);
            ans = Math.max(ans, count);
        }
        return ans;
    }

    private static void dfs(int idx, boolean[] v, int[][] bombs) {
        count++;
        v[idx] = true;
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            if (!v[i] && inRange(bombs[idx], bombs[i])) {
                v[i] = true;
                dfs(i, v, bombs);
            }
        }
    }

    private static boolean inRange(int[] a, int[] b) {
        long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
        return dx * dx + dy * dy <= r * r;
    }

    public static void main(String[] args) {
        int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        int maxDetonation = maximumDetonation(bombs);
        System.out.println("Maximum number of bombs that can be detonated: " + maxDetonation);
    }
}
