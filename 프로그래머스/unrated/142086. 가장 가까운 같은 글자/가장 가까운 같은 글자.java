import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> hashmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hashmap.get(s.charAt(i)) == null){
                answer[i] = -1;
                hashmap.put(s.charAt(i),i);
            }
            else{
                answer[i] = i - hashmap.get(s.charAt(i));
                hashmap.put(s.charAt(i),i);
            }
        }
        return answer;
    }
}