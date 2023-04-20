import java.util.*;
import java.io.*;

class Solution {
    public int solution(int a, int b) {
        int num1 = a*b*2;
        int num2 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int answer = Math.max(num1,num2);
        return answer;
    }
}