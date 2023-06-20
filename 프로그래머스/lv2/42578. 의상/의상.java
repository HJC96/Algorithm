import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int multiple = 1;
        HashMap<String, List<String>> hash = new HashMap<>();
        for(String[] str:clothes){
            if(hash.containsKey(str[1])){
                hash.get(str[1]).add(str[0]);
            }
            else{
                ArrayList<String> ar = new ArrayList<>();
                ar.add(str[0]);
                hash.put(str[1],ar);
            }
        }
        for(Map.Entry<String, List<String>> entry:hash.entrySet()){
            answer *= (entry.getValue().size()+1);
        }
        return answer-1;
    }
}