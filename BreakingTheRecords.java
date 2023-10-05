import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> arr = new ArrayList<>();
        int min = scores.get(0), max = scores.get(0);
        arr.add(0);
        arr.add(0);

        for (int score : scores) {
            if (score < min) {
                min = score;
                arr.set(1, arr.get(1) + 1);
            } else if (score > max) {
                max = score;
                arr.set(0, arr.get(0) + 1);
            }
        }

        return arr;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Reading the number of scores
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // Reading the scores and creating a list
        List<Integer> scores = Stream.of(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = Result.breakingRecords(scores);

        // Printing the result
        System.out.println(result.get(0) + " " + result.get(1));

        bufferedReader.close();
    }
}
a
