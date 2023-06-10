import java.io.*;
import java.util.*;

class Solution {
    public String solution(String code) {
        StringBuffer answer = new StringBuffer();
        boolean mode = false;
        for(int i=0;i<code.length();i++){
            if(code.charAt(i) == '1'){
                mode = (!mode);
            }else{
                if(!mode){
                    if(i%2==0){
                        answer.append(code.charAt(i));
                    }
                }else{
                    if(i%2!=0){
                        answer.append(code.charAt(i));
                    }
                }
            } 
        }
        if(answer.toString().length() == 0)
            answer.append("EMPTY");
        return answer.toString();
    }
}
