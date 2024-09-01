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

        numbers = new int[N+1][2];
        dp = new int[N+1][K+1];

        for(int i=1;i<=N;i++){
            String[] input = br.readLine().split(" ");
            numbers[i][0] = Integer.parseInt(input[0]);
            numbers[i][1] = Integer.parseInt(input[1]);
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++) { // dp가 이차원이면 for문도 2개, j == 현재 가방의 무게
                if(j<numbers[i][0]){
                    dp[i][j] = dp[i-1][j];  // 담을수 없는 경우, 담기전 값으로 유지
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-numbers[i][0]] + numbers[i][1]); // 담을 수 있으면 무조건 담는다, 이때 이전까지의 아이템가치와 현 아이템 무게 + 이전 차수에서 현아이템 무게 전까지 합 중 최대 가치를 비교해봄
                }
            }

        }
        System.out.println(dp[N][K]);
    }
}

