import java.io.*;
import java.util.*;

public class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int length = sequence.length;
        long[] dpPos = new long[length];
        long[] dpNeg = new long[length];
        
        dpPos[0] = sequence[0];
        dpNeg[0] = -sequence[0];
        
        answer = Math.max(dpPos[0], dpNeg[0]);
        for (int i = 1; i < length; i++) {
            if (i % 2 == 0) {
                dpPos[i] = Math.max(dpPos[i - 1] + sequence[i], sequence[i]);
                dpNeg[i] = Math.max(dpNeg[i - 1] - sequence[i], -sequence[i]);
            } else {
                dpPos[i] = Math.max(dpPos[i - 1] - sequence[i], -sequence[i]);
                dpNeg[i] = Math.max(dpNeg[i - 1] + sequence[i], sequence[i]);
            }
            
            answer = Math.max(answer, Math.max(dpPos[i], dpNeg[i]));
        }
        
        return answer;
    }
}