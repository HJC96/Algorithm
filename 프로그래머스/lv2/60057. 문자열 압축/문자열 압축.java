import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int length = s.length();
        int min = length/2; int answer = length;
        while(min>0){
            Stack<String> stk = new Stack<String>();
            for(int i=0;i<length/min;i++){
                String tmp ;
                if(min*i + min >length)
                    tmp = s.substring(min*i,length);
                else
                    tmp = s.substring(min*i,min*i + min);
                stk.add(tmp);
            }
            String top = stk.pop();
            int tmp_answer = length;
            boolean flag = false; int cnt=1;
            while(!stk.isEmpty()){
                String tmp_top = stk.pop();
                if(top.equals(tmp_top)) {
                    flag = true;
                    cnt++;
                }else{
                    if(flag){
                        String cnt_s = Integer.toString(cnt);
                        tmp_answer -= (min*(cnt-1) - cnt_s.length());
                        flag = false;
                        cnt =1;
                    }
                }
                top = tmp_top;
            }
            if(flag){
                String cnt_s = Integer.toString(cnt);
                tmp_answer -= (min*(cnt-1) - cnt_s.length());
            }
            answer = Math.min(answer, tmp_answer);
            min--;
        }
        return answer;
    }
}
