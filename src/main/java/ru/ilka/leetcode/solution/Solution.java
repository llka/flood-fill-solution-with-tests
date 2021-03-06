package ru.ilka.leetcode.solution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;

/**
 * Here could be your advertisement +375 29 3880490
 */
public class Solution {
    private static final Logger logger = LogManager.getLogger(Solution.class);

    class Coordinates {
        int i;
        int j;

        Coordinates(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[] findMaxIsland(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        boolean[][] visited = new boolean[M][N];

        int maxCountKey = matrix[0][0];
        int maxCountValue = 0;
        ArrayDeque<Coordinates> queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int count = 1;
                findAdjacentFieldsCount(matrix, visited, i, j, queue);
                while (!queue.isEmpty()) {
                    Coordinates coordinates = queue.pollFirst();
                    if (!visited[coordinates.i][coordinates.j]) {
                        count++;
                        findAdjacentFieldsCount(matrix, visited, coordinates.i, coordinates.j, queue);
                    }
                }
                if (count > maxCountValue) {
                    maxCountKey = matrix[i][j];
                    maxCountValue = count;
                }
            }
        }
        logger.debug(maxCountKey + ": " + maxCountValue);
        return new int[]{maxCountKey, maxCountValue};
    }

    private int findAdjacentFieldsCount(int[][] matrix, boolean[][] visited, int i, int j,
                                        ArrayDeque<Coordinates> queue) {
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int[][] waysVector = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        for (int k = 0; k < 4; k++) {
            int key = matrix[i][j];
            int iNeighbour = i + waysVector[k][0];
            int jNeighbour = j + waysVector[k][1];
            if (inBounds(iNeighbour, matrix.length) && inBounds(jNeighbour, matrix[0].length)) {
                if (!visited[iNeighbour][jNeighbour] && matrix[iNeighbour][jNeighbour] == key) {
                    queue.push(new Coordinates(iNeighbour, jNeighbour));
                }
            }
        }
        return 0;
    }

    private boolean inBounds(int coordinate, int maxValue) {
        return coordinate > -1 && coordinate < maxValue;
    }
}
