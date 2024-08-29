import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static int[][] dp;
    private static int[][] numbers;
    private static int N, K;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        numbers = new int[N][2];
        dp = new int[N][K+1];
        for(int i=0;i<K+1;i++){
            for(int j=0;j<N;j++){
                dp[j][i] = -1;
            }
        }
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            numbers[i][0] = Integer.parseInt(input[0]);
            numbers[i][1] = Integer.parseInt(input[1]);

        }

        int ans = curr(0, 0);

        System.out.println(ans);
    }

    private static int curr(int weight, int level){
        if(weight >K){
            return -999999;
        }
        if(level==N){
            return 0;
        }

        if(dp[level][weight] != -1){
            return dp[level][weight];
        }


        dp[level][weight] = Math.max(curr(weight + numbers[level][0] , level+1) + numbers[level][1], curr(weight, level+1)); // 선택하지 않고, 넘김

        return dp[level][weight];
    }
}

