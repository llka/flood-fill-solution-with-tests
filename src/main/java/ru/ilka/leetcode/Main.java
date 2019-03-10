package ru.ilka.leetcode;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Here could be your advertisement +375 29 3880490
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hi!");

        System.out.println("I am \'leetcode maven\' project!");
    }

    private static long timestampOnlyWithHours(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.ZONE_OFFSET, 0);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTimeInMillis();
    }

    public static int solution(int[] array) {
        Arrays.sort(array);
        int duplicate = array[0];
        int maxDuplicates = 1;
        int currentDuplicates = 1;
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            if (curr != duplicate) {
                duplicate = curr;
                currentDuplicates = 1;
            } else {
                currentDuplicates++;
                maxDuplicates = Math.max(currentDuplicates, maxDuplicates);
            }
        }
        return maxDuplicates;
    }

    public static void solve2(int n, String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;

        while (leftIdx < rightIdx && leftIdx < str.length() && rightIdx > 0) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                if (isPalindrome(str, leftIdx + 1, rightIdx)) {
                    System.out.println(str.charAt(leftIdx));
                } else {
                    System.out.println(str.charAt(rightIdx));
                }
                return;
            }
            leftIdx++;
            rightIdx--;
        }
    }

    private static boolean isPalindrome(String str, int leftIdx, int rightIdx) {
        while (leftIdx <= rightIdx && leftIdx < str.length() && rightIdx > 0) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }

    public static List<String> readFileByLines(String filePath) {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void writeToFile(String filePath, long num) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(num));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//        String TAXI_REGEX = "^([7](TAX|TBX|TEX)\\s)|([1-6](TAX|TBX)\\s)$";
//        writeToFile("taxi.out",
//                readFileWithCarNumbers("input.txt")
//                        .stream().filter((taxi) -> taxi.length() == 9 &&
//                        taxi.substring(0, 5).matches(TAXI_REGEX)
//                        && taxi.substring(5, 9).matches("[0-9]{4}")
//                        && Integer.parseInt(taxi.substring(5, 9)) >= 1).count());

    //1
    /*import java.util.*;

    class Solution {

        public static void solve(int n, String str) {
            final String TO_BE_REMOVED_REGEX = "(a)|(e)|(i)|(o)|(u)|(A)|(E)|(I)|(O)|(U)";
            String replaced = str.replaceAll(TO_BE_REMOVED_REGEX, "");
            replaced = replaced.trim();

            System.out.println(replaced);
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // Click HELP above to see examples of handling input/debug/output
            // INPUT: int n = in.nextInt();
            // DEBUG: System.out.println(n);
            // OUTPUT: System.out.println(result);

            // Write the code to solve the problem below,
            // format the "result" as specified in the problem statement
            // and finally, write the result to stdout
            // IMPORTANT: Remove all debug statements for final submission
            int n = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            solve(n, str);
            in.close();
        }
    }*/

    //2
    /*
        import java.util.*;

class Solution {

	public static int solve(int n, int k, String str) {
	    int result = 0;
        int[] prefixCountForOnes = new int[str.length() + 1];

        int currentOnesCount = 0;
        prefixCountForOnes[currentOnesCount]++;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                currentOnesCount++;
            }
            prefixCountForOnes[currentOnesCount]++;
        }

        for (int i = 0; i < prefixCountForOnes.length - k; i++) {
            result += prefixCountForOnes[i] * prefixCountForOnes[i + k];
        }
        return result;
	}

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       // Click HELP above to see examples of handling input/debug/output
       // INPUT: int n = in.nextInt();
       // DEBUG: System.out.println(n);
       // OUTPUT: System.out.println(result);

       // Write the code to solve the problem below,
       // format the "result" as specified in the problem statement
       // and finally, write the result to stdout
       // IMPORTANT: Remove all debug statements for final submission
		int n = in.nextInt();
		int k = in.nextInt();
		String str = in.next();
		System.out.println(solve(n, k, str));
		in.close();
    }
}

    */

    //3
    /*
    import java.util.*;

class Solution {

	public static void solve(int n, int k, String regex, String str) {
	    final String YES = "YES";
        String result = "NO";

        int regexIndex = 0;
        int strIndex = 0;

        while (regexIndex < regex.length() && strIndex < str.length()) {
            if (str.charAt(strIndex) == regex.charAt(regexIndex)) {
                regexIndex++;
            }
            strIndex++;
        }

        if (regexIndex == regex.length()) {
            result = YES;
        }

        System.out.println(result);
	}

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       // Click HELP above to see examples of handling input/debug/output
       // INPUT: int n = in.nextInt();
       // DEBUG: System.out.println(n);
       // OUTPUT: System.out.println(result);

       // Write the code to solve the problem below,
       // format the "result" as specified in the problem statement
       // and finally, write the result to stdout
       // IMPORTANT: Remove all debug statements for final submission
		int n = in.nextInt();
		int k = in.nextInt();
		in.nextLine();
		String str1 = in.next();
		in.nextLine();
		String str2 = in.next();
		solve(n, k, str1, str2);
		in.close();
    }
}

     */

    //4
    /*
    import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

	public static void solve(int n, String[] arr) {
       Stream.of(arr).
                sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList())
                .forEach(s -> System.out.print(s + " "));
	}

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       // Click HELP above to see examples of handling input/debug/output
       // INPUT: int n = in.nextInt();
       // DEBUG: System.out.println(n);
       // OUTPUT: System.out.println(result);

       // Write the code to solve the problem below,
       // format the "result" as specified in the problem statement
       // and finally, write the result to stdout
       // IMPORTANT: Remove all debug statements for final submission
		int n = in.nextInt();
		String[] arr = new String[n];
		in.nextLine();
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextLine();
		}
		solve(n, arr);
		in.close();
    }
}

     */

    //5
    /*

   import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

	public static void solve(int n, String str) {
         System.out.println(Stream.of(str.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
	}

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       // Click HELP above to see examples of handling input/debug/output
       // INPUT: int n = in.nextInt();
       // DEBUG: System.out.println(n);
       // OUTPUT: System.out.println(result);

       // Write the code to solve the problem below,
       // format the "result" as specified in the problem statement
       // and finally, write the result to stdout
       // IMPORTANT: Remove all debug statements for final submission
		int n = in.nextInt();
		String str = in.next();
		solve(n, str);
		in.close();
    }
}

     */

}

