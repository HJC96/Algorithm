import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> tmpAns = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            if(i%5 == 0) 
                tmpAns.add(names[i]);
        }
        String [] answer = new String[tmpAns.size()];
        for(int i=0;i<tmpAns.size();i++){
            answer[i] = tmpAns.get(i);
        }
        return answer;
    }
}