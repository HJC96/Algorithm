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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        curr(0, 1);

    }

    private static void curr(int n, int start){
        if(n == M){
            for(int i:nums){
                System.out.print(i + " ");
            }
            System.out.println();
            return ;
        }

        for(int i=start;i<=N;i++) {
            if(nums.contains(i)) {
                continue;
            }
            nums.add(i);
            curr(n+1, i+1);
            nums.remove(nums.size() - 1);
        }
    }
}

