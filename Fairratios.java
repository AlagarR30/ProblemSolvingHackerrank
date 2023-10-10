import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) {
    // Write your code here
   int  cout=0;
    for(int i=B.size()-1;i>0;i--){
        if(B.get(i)%2==0){
            continue;
        }
        else{
            cout+=2;
            B.set(i, B.get(i)+1);
            B.set(i-1, B.get(i-1)+1);
        }
    }
    int count=0;
    for(int k:B){
        if(k%2!=0){
            count++;
        }
    }
    String str="";
    if(cout==0&&count!=0){
        return "NO";
    }
    if(count==0||cout==0){
        str=String.valueOf(cout);
    }
    else if(count!=0){
        str="NO";
    }
return str;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
