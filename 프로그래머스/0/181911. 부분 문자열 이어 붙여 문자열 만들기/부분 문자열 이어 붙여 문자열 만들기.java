import java.io.*;
import java.util.*;


class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<parts.length;i++){
            int start = parts[i][0];
            int end = parts[i][1]+1;
            
            result.append(my_strings[i].substring(start, end));
        }

        return result.toString();
    }
}