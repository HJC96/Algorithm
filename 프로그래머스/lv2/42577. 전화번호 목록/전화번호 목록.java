import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book,
    (s1, s2) -> 
                    {return Integer.compare(s2.length(), s1.length());}
            
        );
        
        HashMap<String, Integer> hash = new HashMap<>();
        for(String str:phone_book){
            if(hash.containsKey(str)) return false;
            else{
                String tmp ="";
                for(int i=0;i<str.length();i++){
                    tmp += str.charAt(i);
                    hash.put(tmp, 0);
                }
            }




        }
        
        
        return answer;
    }
}