import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int front=0; int end=people.length-1;
        while(front<=end){ // 추후 등호 고려
            if(people[front]+people[end] > limit){
                answer++;
                end-=1;
            }else{
                front++;
                end-=1;
                answer++;
            }
        }
        
        return answer;
    }
}