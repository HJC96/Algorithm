import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        int [] arr = new int[N+1];

        for(int i=0;i<=N;i++){
            dp[i] = 1;
        }

        String[] line = br.readLine().split(" ");
        int idx = 0;
        for(String l:line){
            arr[idx++] = Integer.parseInt(l);
        }
        int max = 1;
        for(int i=1;i<=N;i++){
            for(int j=0;j<i;j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(max);
    }
}

