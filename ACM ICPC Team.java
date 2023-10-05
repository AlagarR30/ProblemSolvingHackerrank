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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
    List<Integer>res=new ArrayList<>();
    int max=0;
    int teams=0;
    for(int i=0;i<topic.size();i++){
        for(int j=i+1;j<topic.size();j++){
            int tp=0;
            BigInteger deci1=new BigInteger(topic.get(i),2);
            BigInteger deci2=new BigInteger(topic.get(j),2);
            BigInteger resdesi=deci1.or(deci2);
            String resBi=resdesi.toString(2);
            for(char a:resBi.toCharArray()){
                if(a=='1'){
                    tp++;
                }
            }
            //System.out.println(tp);
            if(tp>max){
                max=tp;
                teams=1;
            }
            else if(tp==max){
                teams++;
            }
    
        }
    }
res.add(max);
res.add(teams);
return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
