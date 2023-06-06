import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i=1;i<numLog.length;i++){
            int num = numLog[i] - numLog[i-1];
            switch(num){
                case 1:
                    answer += 'w';
                    break;
                case -1:
                    answer += 's';
                    break;
                case 10:
                    answer += 'd';
                    break;
                case -10:
                    answer += 'a';
                    break;
                default :
                    break;
            }
        }
        
        
        return answer;
    }
}