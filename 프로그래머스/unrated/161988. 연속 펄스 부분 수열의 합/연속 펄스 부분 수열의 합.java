import java.io.*;
import java.util.*;

public class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int length = sequence.length;
        long[] dpPos = new long[length];
        long[] dpNeg = new long[length];

        
        int[] purse = new int[length];
        purse[0] = 1;
        for(int i=1;i<length;i++){
            purse[i] = -1*purse[i-1];
        }
        for(int i=0;i<length;i++) sequence[i] = sequence[i]*purse[i];

        dpPos[0] = sequence[0];
        dpNeg[0] = sequence[0];
        answer = Math.abs(sequence[0]);
        for (int i = 1; i < length; i++) {
            dpPos[i] = Math.max(dpPos[i - 1] + sequence[i], sequence[i]);
            dpNeg[i] = Math.min(dpNeg[i - 1] + sequence[i], sequence[i]);
            answer = Math.max(answer, Math.max(Math.abs(dpPos[i]), Math.abs(dpNeg[i])));
        }

        return answer;
    }
}