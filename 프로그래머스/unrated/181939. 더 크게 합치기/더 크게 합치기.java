import java.util.*;
import java.io.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String str1; String str2; String str3; String str4;
        str1 = Integer.toString(a);
        str2 = Integer.toString(b);
        str3 = str1 + str2;
        str4 = str2 + str1;
        
        answer = Math.max(Integer.parseInt(str3),Integer.parseInt(str4));
        
        return answer;
    }
}