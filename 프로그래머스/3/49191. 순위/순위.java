import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean [][] wins = new boolean[n+1][n+1];
        boolean [][] loses = new boolean[n+1][n+1];
        int answer = 0;
        for(int[] result:results){
            wins[result[0]][result[1]] = true;
            loses[result[1]][result[0]] = true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                for(int k=1;k<n+1;k++){
                    if((wins[i][k] == true) && (wins[k][j] == true)) {
                        wins[i][j] = true;
                        loses[j][i] = true;
                    }
                    if((loses[i][k] == true) && (loses[k][j] == true)) {
                        wins[j][i] = true;
                        loses[i][j] = true;
                    }
                }
            }
        }

        for(int i=1;i<n+1;i++){
            int tmpNumber = 0;
            for(int j=1;j<n+1;j++){
                if((loses[i][j] == true) || (wins[i][j] == true)) tmpNumber++;
            }
            if(tmpNumber == n-1) answer++;
        }



        return answer;
    }
}