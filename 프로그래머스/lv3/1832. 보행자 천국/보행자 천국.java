import java.io.*;
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] cityMap) {
        int MOD = 20170805;
        int[][][] dp = new int[m][n][2];

        dp[0][0][0] = 1;
        dp[0][0][1] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                /* right: 0 */
                if(j>=1){
                    if(cityMap[i][j-1] == 0){
                        dp[i][j][0] += (dp[i][j-1][0] + dp[i][j-1][1] ) % MOD;
//                        if(i>=1)
//                            dp[i][j][1] += (dp[i-1][j][1]) % MOD;
                    }
                    else if(cityMap[i][j-1] == 1){
                        dp[i][j][0] = 0;
//                        dp[i][j][1] = 0;
                    }
                    else{
                        dp[i][j][0] += (dp[i][j-1][0]) % MOD;
                    }
                }
                /* down: 1 */
                if(i>=1){
                    if(cityMap[i-1][j] == 0){
                        dp[i][j][1] += (dp[i-1][j][0]+dp[i-1][j][1]) % MOD;
//                        if(j>=1)
//                            dp[i][j][0] += (dp[i][j-1][1]) % MOD;

                    }
                    else if(cityMap[i-1][j] == 1){
//                        dp[i][j][0] = 0;
                        dp[i][j][1] = 0;
                    }
                    else{
                        dp[i][j][1] += (dp[i-1][j][1]) % MOD;
                    }
                }

            }
        }

        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}