import java.io.*;
import java.util.*;

class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer ="";
        StringBuffer sb = new StringBuffer();
        for(int idx:index_list)
            sb.append(my_string.charAt(idx));
        
        return sb.toString();
    }
}