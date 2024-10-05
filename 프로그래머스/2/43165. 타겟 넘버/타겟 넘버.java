import java.io.*;
import java.util.*;

class Solution {
    private static int answer = 0;
    private static int t = 0;
    public int solution(int[] numbers, int target) {
        t = target;
        curr(numbers, 0, 0);
        return answer;
    }
    
    private void curr(int[] numbers, int current, int sum){
        if(current == numbers.length){
            if(sum == t){
                answer++;
            }
            return ;
        }
        curr(numbers, current+1, sum + numbers[current]);
        curr(numbers, current+1, sum - numbers[current]);
    }
}