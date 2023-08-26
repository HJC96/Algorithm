import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1}; // 불가능한 경우
        
        int baseValue = s / n;
        int remainder = s % n;

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = baseValue;
        }

        // 나머지만큼 1씩 더해 분포시키기
        for (int i = 0; i < remainder; i++) {
            answer[n - 1 - i] += 1; // 뒤에서부터 1을 더해 큰 값을 만든다
        }
        
        return answer;
    }
}
