import java.io.*;
import java.util.*;


class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 1;
        int len = Math.min(is_prefix.length(), my_string.length());
        if(len == my_string.length()) {answer = 0;}
        else{
        for(int i=0;i<len;i++){
            if(my_string.charAt(i) != is_prefix.charAt(i)){
                answer = 0;
                break;
            }
        }}
        return answer;
    }
}