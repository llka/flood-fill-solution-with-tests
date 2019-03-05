package ru.ilka.leetcode.solution;

import javafx.util.Pair;

import java.util.ArrayDeque;

/**
 * Here could be your advertisement +375 29 3880490
 */
public class Solution {
    public int[] findMaxIsland(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        boolean[][] visited = new boolean[M][N];

        int maxCountKey = matrix[0][0];
        int maxCountValue = 0;
        ArrayDeque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int count = findAdjacentFieldsCount(matrix, visited, i, j, queue);
                if (count > maxCountValue) {
                    maxCountKey = matrix[i][j];
                    maxCountValue = count;
                }
            }
        }
        System.out.println(maxCountKey + ": " + maxCountValue);

        return new int[]{maxCountKey, maxCountValue};
    }

    private int findAdjacentFieldsCount(int[][] matrix, boolean[][] visited, int i, int j,
                                        ArrayDeque<Pair<Integer, Integer>> queue) {
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int count = 1;
        int[][] waysVector = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int k = 0; k < 4; k++) {
            int key = matrix[i][j];
            int iNeighbour = i + waysVector[k][0];
            int jNeighbour = j + waysVector[k][1];
            if (inBounds(iNeighbour, matrix.length) && inBounds(jNeighbour, matrix[0].length)) {
                if (!visited[iNeighbour][jNeighbour] && matrix[iNeighbour][jNeighbour] == key) {
                    queue.push(new Pair<>(iNeighbour, jNeighbour));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> coordinates = queue.poll();
                        count += findAdjacentFieldsCount(matrix, visited,
                                coordinates.getKey(), coordinates.getValue(), queue);
                    }
                }
            }
        }
        return count;
    }

    private boolean inBounds(int coordinate, int maxValue) {
        return coordinate > -1 && coordinate < maxValue;
    }
}
