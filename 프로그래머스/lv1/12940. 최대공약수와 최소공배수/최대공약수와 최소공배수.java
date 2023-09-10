import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int minValue, minNum, maxValue, maxNum;
        minValue = minNum = Math.min(n,m);
        maxValue = maxNum = Math.max(n,m);
        for(int i=1;i<=minValue;i++){
            if(n%i == 0 && m%i == 0){
                answer[0] = i;
            }
        }
        
        
        while(maxValue != minValue){
            if(maxValue < minValue){
                maxValue += maxNum;
            }
            else if(maxValue > minValue){
                minValue += minNum;
            }
        }
        answer[1] = minValue;
        
        
        return answer;
    }
}