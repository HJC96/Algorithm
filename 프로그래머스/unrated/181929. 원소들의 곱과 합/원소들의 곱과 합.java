import java.io.*;
import java.util.*;

class Solution {
    public int AdditionAndSquare(int[] list){
        int answer = 0;
        for(Integer i:list)
            answer += i;
        answer = (int)Math.pow(answer, 2);
        return answer;
    }
    public int Mul(int[] list){
        int answer = 1;
        for(Integer i:list)
            answer *= i;
        return answer;
    }
    public int solution(int[] num_list) {
        Solution s = new Solution();
        if(s.AdditionAndSquare(num_list) > Mul(num_list))
            return 1;
        else
            return 0;
    }
}