import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        List<String> strList = new ArrayList<>();
        for(int i=0;i<str_list.length;i++){
            if(str_list[i].charAt(0) == 'l'){
                for(int j=0;j<i;j++){
                    strList.add(str_list[j]);    
                }
                break;
            }else if(str_list[i].charAt(0) == 'r'){
                for(int j=i+1;j<str_list.length;j++){
                    strList.add(str_list[j]);    
                }
                break;
            }
        }
        String[] answer = new String[strList.size()];
        for(int i=0;i<strList.size();i++){
            answer[i] = strList.get(i);
        }
        return answer;
    }
}