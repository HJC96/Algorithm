import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1}; // 불가능한 경우
        
        int Quotient = s / n;
        int remainder = s % n;

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Quotient;
        }
        
        int idx=0;
        while(remainder > 0){
            if(idx >= n) idx=0;
            answer[idx++]++;
            remainder--;
        }
        
        Arrays.sort(answer);
        
        
        return answer;
    }
}
