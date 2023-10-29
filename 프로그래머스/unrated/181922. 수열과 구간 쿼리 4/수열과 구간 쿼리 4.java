import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            answer[i] = arr[i];
        }
        
        for(int[] i:queries){
            for(int j=i[0];j<=i[1];j++){
                if(j%i[2] == 0){
                    answer[j] += 1;    
                }
            }
        }
        return answer;
    }
}