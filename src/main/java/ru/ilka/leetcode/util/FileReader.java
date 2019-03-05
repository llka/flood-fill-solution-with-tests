package ru.ilka.leetcode.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    public static int[][] readMatrixFromFile(String filePath) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        List<String> lines = Files.readAllLines(Paths.get(filePath), charset);
        List<List<Integer>> matrix = new ArrayList<>();
        for (String line : lines) {
            ArrayList<Integer> row = new ArrayList<>();
            Stream.of(line.split(" ")).forEach(s -> row.add(Integer.parseInt(s)));
            matrix.add(row);
        }
        return matrix.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static int[] readAnswerFromFile(String filePath) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        List<String> lines = Files.readAllLines(Paths.get(filePath), charset);
        return Stream.of(lines.get(0).split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
