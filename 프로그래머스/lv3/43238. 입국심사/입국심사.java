

import java.io.*;
import java.util.*;

public class Solution {
    public long solution(int n, int[] times) {
        long answer = 1;
        int length = times.length;
        Arrays.sort(times);

        while(n>0){
            for(int i=0;i<length;i++){
                if(answer % times[i] == 0)
                    n--;
            }
            answer++;
        }

        return answer-1;
    }
}