import java.io.*;
import java.util.*;

enum  USER_CASE {MULTIPLY, ADD;}



class Solution {
    public int solution(int[] num_list) {
        int answer = 1;
        USER_CASE user_case;
        user_case = USER_CASE.MULTIPLY;
        if(num_list.length >= 11){
            user_case = USER_CASE.ADD;
            answer = 0;
        }
            
        switch(user_case){
            case MULTIPLY:
                for(int i=0;i<num_list.length;i++){  answer *= num_list[i];}
                break;
            case ADD:
                for(int i=0;i<num_list.length;i++){  answer += num_list[i];}
                break;
        }
        return answer;
    }
}