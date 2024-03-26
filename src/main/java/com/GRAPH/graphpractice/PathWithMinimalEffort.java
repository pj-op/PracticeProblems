package com.GRAPH.graphpractice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class PathWithMinimalEffort {
    public static void main(String[] args) {
        int[][] test = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int[] src = {0, 0};
        int[] dest = {test.length - 1, test[0].length - 1};
        System.out.println(pathWithMinimalEffort(test, src, dest));
    }

    private static int pathWithMinimalEffort(int[][] test, int[] src, int[] dest) {
        int n = test.length;
        int m = test[0].length;
        int[][] dist = new int[n][m];
        Arrays.stream(dist).forEach(i -> Arrays.fill(i, Integer.MAX_VALUE));
        dist[src[0]][src[1]] = 0;

        Queue<MinimalPath> pq = new PriorityQueue<>(Comparator.comparingInt(MinimalPath::getDistance));
        MinimalPath firstNode = new MinimalPath(src[0], src[1], dist[src[0]][src[1]]);
        pq.add(firstNode);

        System.out.println(pq);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, -1, 0};

        while (!pq.isEmpty()) {
            MinimalPath currNode = pq.poll();
            int currRow = currNode.getPRow();
            int currCol = currNode.getPCol();
            int currDist = currNode.getDistance();

            if (currRow == n - 1 && currCol == m - 1) return currDist;

            for (int i = 0; i < delRow.length; i++) {
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m) {
                    int abs = Math.abs(test[currRow][currCol] - test[nRow][nCol]);
                    int effort = Math.max(abs, currDist);
                    if (effort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = effort;
                        pq.add(new MinimalPath(nRow, nCol, effort));
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
        return 0;
    }
}

@Data
@AllArgsConstructor
class MinimalPath {
    int pRow;
    int pCol;
    int distance;
}
