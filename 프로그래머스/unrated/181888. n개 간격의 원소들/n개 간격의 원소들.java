import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[(int)Math.ceil((double)num_list.length/n)];
        int idx=0;
        for(int i=0;i<num_list.length;i++){
            if(i%n==0){
                answer[idx++] = num_list[i];
            }
        }
        
        return answer;
    }
}