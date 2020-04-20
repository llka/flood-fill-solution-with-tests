package ru.ilka.leetcode.solution;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.ilka.leetcode.util.FileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FloodFillTest {
    private Solution solution;

    private String testDataPath;
    private String testAnswerPath;

    public FloodFillTest(String testDataPath, String testAnswerPath) {
        this.testDataPath = testDataPath;
        this.testAnswerPath = testAnswerPath;
    }

    @Parameterized.Parameters(name = "{index}: {1} - {0}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"testcases/case_1x1.txt", "testcases/case_1x1_answer.txt"},
                {"testcases/case_3x6.txt", "testcases/case_3x6_answer.txt"},
                {"testcases/case_5x5.txt", "testcases/case_5x5_answer.txt"},
                {"testcases/case_15x10.txt", "testcases/case_15x10_answer.txt"},
                {"testcases/case_100x100.txt", "testcases/case_100x100_answer.txt"},
                {"testcases/case_256x256.txt", "testcases/case_256x256_answer.txt"},
                {"testcases/case_300x200.txt", "testcases/case_300x200_answer.txt"},
                {"testcases/case_512x512.txt", "testcases/case_512x512_answer.txt"},
                {"testcases/case_1024x1024.txt", "testcases/case_1024x1024_answer.txt"}
        });
    }

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void testAllCasesOfFloodFill() throws IOException {
        int[] actualResult = solution.findMaxIsland(FileReader.readMatrixFromFile(testDataPath));
        int[] expectedResult = FileReader.readAnswerFromFile(testAnswerPath);
        assertEquals(expectedResult[0], actualResult[0]);
        assertEquals(expectedResult[1], actualResult[1]);
    }
}
