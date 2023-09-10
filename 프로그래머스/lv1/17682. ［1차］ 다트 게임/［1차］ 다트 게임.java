import java.io.*;
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int []parseInt = new int[3];
        String parsedNumber = "";
        int idx=0;
        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            if('0'<=c && c<='9'){
                parsedNumber += c;
            }else if(c == 'S' || c =='D' || c =='T'){
                if(c =='S'){
                    parseInt[idx] = (int)Math.pow(Integer.parseInt(parsedNumber), 1);
                }else if(c =='D'){
                    parseInt[idx] = (int)Math.pow(Integer.parseInt(parsedNumber), 2);
                }else{
                    parseInt[idx] = (int)Math.pow(Integer.parseInt(parsedNumber), 3);
                }
                parsedNumber = "";
                idx+=1;
            }
            else{
                if(c == '*'){
                    parseInt[idx-1] *=2;
                    if(idx >=2) parseInt[idx-2] *=2;
                }else if(c == '#'){
                    parseInt[idx-1] *=-1;
                }
            }
        }
        for(int i:parseInt)
            answer += i;
        return answer;
    }
}
// s:83
// d:68
// T:84
// *:42
// #:35

/*
1 2 3
s d T
*

애초에 10이란건 아스키코드에 없네..



*/