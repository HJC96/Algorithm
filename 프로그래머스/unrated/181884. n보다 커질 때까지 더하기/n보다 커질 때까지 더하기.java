import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for(Integer i:numbers){
            if(answer <= n)
                answer += i;
        }
        return answer;
    }
}