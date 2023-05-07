import java.io.*;
import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int len = my_string.length();
        for(int i=len-1;i>=len-n;i--){
            answer = my_string.charAt(i) + answer;
        }
        return answer;
    }
}