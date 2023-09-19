import java.io.*;
import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        /*Make DP*/
        int [][][] dp = new int[m][n][2];

        /* 0 -> down, 1 -> right*/
        dp[0][0][0] = 1;
        dp[0][0][1] = 0;

        for(int i=1;i<m;i++){
            if(cityMap[i][0] == 0|| cityMap[i][0] == 2)
                dp[i][0][0] = 1;
            else
                dp[i][0][0] = 0;
            dp[i][0][1] = 0;
        }
        for(int j=1;j<n;j++){
            if(cityMap[0][j] == 0 || cityMap[0][j] == 2)
                dp[0][j][1] = 1;
            else
                dp[0][j][1] = 0;
            dp[0][j][0] = 0;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(cityMap[i-1][j] == 1){
                    dp[i][j][0] = 0;
                }else if(cityMap[i-1][j] == 0){
                    dp[i][j][0] += (dp[i-1][j][0] + dp[i-1][j][1])%MOD;
                }else{
                    dp[i][j][0] += (dp[i-1][j][0])%MOD;
                }

                if(cityMap[i][j-1] == 1){
                    dp[i][j][1] = 0;
                }else if(cityMap[i][j-1] == 0){
                    dp[i][j][1] += (dp[i][j-1][0] + dp[i][j-1][1])%MOD;
                }else{
                    dp[i][j][1] += (dp[i][j-1][1])%MOD;
                }

            }
        }
        int answer = (dp[m-1][n-1][0] + dp[m-1][n-1][1])%MOD;
        return answer;
    }
}

/*

## 1. DP 만들기.
이중 포문 만들었음. i, j 의 범위를 어떻게?
지금 어떤 영역을 채워야할지부터 정하는게 좋겠음.

*방향 고려 필요

## 2. 통행금지 부분 고려
1. 통행금지 부분을 전부 0으로 셋해두고, dp를 시작하면 어떻게 될까?

그니깐 지금 확인하고 싶은 것은...


*/