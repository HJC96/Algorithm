import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int N;
    private static int M;
    private static List<Integer> nums = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        curr(0, 1);
        System.out.println(sb);
    }

    private static void curr(int n, int start){
        if(n == M){
            for(int i:nums){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return ;
        }

        for(int i=start;i<=N;i++) {
            nums.add(i);
            curr(n+1, i);
            nums.remove(nums.size() - 1);
        }
    }
}




