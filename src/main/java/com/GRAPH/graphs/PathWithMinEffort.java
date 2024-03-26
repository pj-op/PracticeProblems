package com.GRAPH.graphs;

import org.springframework.data.jpa.repository.Query;

import java.util.*;
import java.util.stream.IntStream;

public class PathWithMinEffort {
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(minimumEffortPath(heights));
    }
    public static int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        IntStream.range(0, dist.length).forEach(i -> Arrays.fill(dist[i], Integer.MAX_VALUE));

        RC src = new RC(0, 0, 0);
        dist[src.row][src.col] = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        Queue<RC> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.diff));
        queue.add(src);

        while (!queue.isEmpty()) {
            RC currNode = queue.poll();
            int currRow = currNode.row;
            int currCol = currNode.col;
            int currDiff = currNode.diff;

            if (currRow == n - 1 && currCol == m - 1) return currDiff;

            for (int i = 0; i < delRow.length; i++) {
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int diff = Math.max(currDiff, Math.abs(heights[nRow][nCol] - heights[currRow][currCol]));
                    if (diff < dist[nRow][nCol]) {
                        dist[nRow][nCol] = diff;
                        queue.add(new RC(diff, nRow, nCol));
                    }
                }
            }
        }
        return 0;
    }
}

class RC {
    int diff;
    int row;
    int col;

    RC(int diff, int row, int col) {
        this.diff = diff;
        this.row = row;
        this.col = col;
    }
}