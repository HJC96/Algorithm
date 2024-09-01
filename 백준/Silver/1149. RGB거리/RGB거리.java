import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][]dp = new int[N+1][3];
        int [][]arr = new int[N+1][3];
        for(int i=1;i<=N;i++){
            for(int j=0;j<3;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        String[] line;
        for(int i=1;i<=N;i++){
            line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
            arr[i][2] = Integer.parseInt(line[2]);
        }
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            for(int j=0;j<3;j++){
                if(j==0){
                    dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][j];
                }else if(j==1) {
                    dp[i][1] = Math.min(dp[i-1][2],dp[i-1][0]) + arr[i][j];
                }else{
                    dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][j];
                }
                if(i==N){
                    answer = Math.min(answer, dp[i][j]);
                }
            }

        }
        System.out.println(answer);
    }
}