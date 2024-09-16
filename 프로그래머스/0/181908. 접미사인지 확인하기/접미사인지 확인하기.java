import java.io.*;
import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 1;
        int my_string_length = my_string.length();
        int is_suffix_length = is_suffix.length();
        if(my_string_length < is_suffix_length){
            answer = 0;
        }else{
            for(int i=is_suffix_length-1;i>=0;i--){
                int end = i + my_string_length - is_suffix_length;
                if(my_string.charAt(end) != is_suffix.charAt(i)){
                    answer = 0;
                    break ;
                }
            }
        }
        return answer;
    }
}