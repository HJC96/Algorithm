import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stk = new Stack<>();
        List<Integer> lis = new ArrayList<>();
        int end = progresses.length-1;
        for(int i=end;i>=0;i--){
            stk.add(progresses[i]);
        }
        int cnt = 0; int idx=0; int time=1;
        int value = speeds[idx];
        while(!stk.empty()){
            if(stk.peek() + value*(time) >=100){
                cnt++; stk.pop();
                if(!stk.empty())
                    value = speeds[++idx];
                continue;
            }
            if(cnt > 0){
                lis.add(cnt);
                cnt = 0; 
            }
            time++;
        }
        lis.add(cnt);
        int[] answer = new int[lis.size()]; 
        for(int i=0;i<lis.size();i++){
            answer[i] = lis.get(i);
        }
        return answer;
    }
}