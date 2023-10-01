import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
        int[][] map = new int[length][length];
        map[0][0] = triangle[0][0];
        for(int i=1;i<length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(1<=j && j<triangle[i].length-1 ){
                   map[i][j] = Math.max(map[i-1][j-1],map[i-1][j]) + triangle[i][j];
                    if(map[i][j] >= answer) answer = Math.max(answer, map[i][j]);
                }
                
                else{
                    if(j==0)
                        map[i][j] = map[i-1][j] + triangle[i][j];
                    else 
                        map[i][j] = map[i-1][j-1] + triangle[i][j];
                    if(map[i][j] >= answer) answer = Math.max(answer, map[i][j]);
                }
            }
        }
        return answer;
    }
}