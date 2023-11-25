import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> hashMap = new HashMap<>();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char type : types) {
            hashMap.put(type, 0);
        }
        for(int i=0;i< survey.length;i++){
            int value = choices[i]-4;
            if(value == 0){

            }else if(value > 0){
                
                hashMap.put(survey[i].charAt(1), hashMap.get(survey[i].charAt(1)) + Math.abs(value));
            }else{
                hashMap.put(survey[i].charAt(0), hashMap.get(survey[i].charAt(0)) + Math.abs(value));
            }
        }
        String answer = "";
        
        if(hashMap.get('R') > hashMap.get('T')){
            answer += 'R';
        }
        else if(hashMap.get('R') == hashMap.get('T')){
            answer += 'R';
        }
        else{
            answer += 'T';
        }

        if(hashMap.get('C') > hashMap.get('F')){
            answer += 'C';
        }
        else if(hashMap.get('C') == hashMap.get('F')){
            answer += 'C';
        }
        else{
            answer += 'F';
        }

        if(hashMap.get('J') > hashMap.get('M')){
            answer += 'J';
        }else if(hashMap.get('J') == hashMap.get('M')){
            answer += 'J';
        }
        else{
            answer += 'M';
        }

        if(hashMap.get('A') > hashMap.get('N')){
            answer += 'A';
        }else if(hashMap.get('A') == hashMap.get('N')){
            answer += 'A';
        }
        else{
            answer += 'N';
        }

        return answer;
    }
}