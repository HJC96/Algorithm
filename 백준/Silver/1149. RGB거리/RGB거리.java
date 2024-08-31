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
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1][3];
        dp = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=0;j<N;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<=N;i++){
            String[] line = br.readLine().split(" ");
            numbers[i][0] = Integer.parseInt(line[0]);
            numbers[i][1] = Integer.parseInt(line[1]);
            numbers[i][2] = Integer.parseInt(line[2]);
        }
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            for(int j=0;j<3;j++){
                int result = Integer.MAX_VALUE;
                if(j==0){
                    result = numbers[i][0]+ Math.min(dp[i-1][1], dp[i-1][2]);
                }else if(j==1){
                    result = numbers[i][1]+ Math.min(dp[i-1][0], dp[i-1][2]);
                }else if(j==2){
                    result = numbers[i][2]+ Math.min(dp[i-1][0], dp[i-1][1]);
                }
                dp[i][j] = Math.min(dp[i][j], result);
                if(i==N){
                    answer = Math.min(dp[i][j], answer);
                }
            }
        }
        System.out.println(answer);
        
    }
}

