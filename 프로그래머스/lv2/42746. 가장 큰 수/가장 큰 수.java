import java.io.*;
import java.util.*;


class Solution {
    public String solution(int[] numbers) {
        
        List<String> ansList = new ArrayList<>();
        
        for(int i:numbers){
            String answer = "";
            ansList.add(answer + i);
        }
        
        Collections.sort(ansList, (a,b)->{
           return Integer.compare(Integer.parseInt(b+a),Integer.parseInt(a+b));
        });
        
        String answer = "";
        for(String s:ansList)
            answer +=s;
        if(answer.charAt(0)=='0') return "0";
        else return answer;
    }
}