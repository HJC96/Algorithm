import java.io.*;
import java.util.*;

class Solution {
    int y ; int x;
    int [][]dp;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        x = m;
        y = n;
        dp = new int [y][x];
        dp[0][0] = 1;
        for(int[] pud:puddles){
            dp[pud[1]-1][pud[0]-1] = -1;
        }
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                if(dp[i][j] == -1) { dp[i][j] =0;continue;}
                if(j != 0){
                    dp[i][j] = (dp[i][j] + dp[i][j-1])%1000000007  ;
                }
                if(i != 0){
                    dp[i][j] = (dp[i][j] + dp[i-1][j])%1000000007 ;
                }
            }
        }
        return dp[y-1][x-1];
    }
}