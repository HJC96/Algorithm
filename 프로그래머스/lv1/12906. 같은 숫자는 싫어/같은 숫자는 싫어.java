import java.io.*;
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> st = new Stack<>();
        
        for(int i:arr){
            if(st.isEmpty())    st.push(i);
            else{
                if(st.peek() != i)
                    st.push(i);
                else
                    continue;
            }
        }
        answer = new int[st.size()];
        int idx=0;
        for(int i:st){
            answer[idx++] = i;
        }
        
        return answer;
    }
}