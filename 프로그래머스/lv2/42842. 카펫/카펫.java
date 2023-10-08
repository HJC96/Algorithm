
import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[]{0,0};
        int sum = brown+yellow;
        Map<Integer, Integer> m = new HashMap<>();
            for(int i=3;i<=Math.sqrt(sum);i++){
              if(sum % i==0){
                  m.put(sum/i,i);
                 
              }
            }

        for(Map.Entry<Integer, Integer> h:m.entrySet()){
            int a = h.getKey();
            int b = h.getValue();
            if((a-2) * (b-2) == yellow && (a+b-2)*2 ==brown) {answer[0] =a; answer[1] =b; }
        }
        return answer;
    }
}