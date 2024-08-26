import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int N;
    private static int M;
    private static List<Integer> nums = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        line = br.readLine().split(" ");

        for(String s:line){
            numbers.add(Integer.parseInt(s));
        }

        Collections.sort(numbers,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });

        curr(0);
        System.out.println(sb);
    }

    private static void curr(int n){
        if(n == M){
            for(int i:nums){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for(int i=0;i<N;i++) {
            int num = numbers.get(i);
            if(nums.contains(num)){
                continue;
            }
            nums.add(num);
            curr(n+1);
            nums.remove(nums.size() - 1);
        }
    }
}




