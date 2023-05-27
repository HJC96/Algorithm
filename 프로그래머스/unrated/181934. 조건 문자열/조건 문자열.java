import java.io.*;
import java.util.*;


class Solution {
    
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        int k = (Integer)(ineq.charAt(0)-'0');
        int l = (Integer)(eq.charAt(0)-'0');
        switch(k)
        {
            case 12: 
                System.out.print(l);
                if(l == 13){
                    if(n <= m)  answer = 1;
                }
                else{
                    if(n < m)  answer = 1;
                }
                break;
            case 14:
                if(l == 13){
                    if(n >= m)  answer = 1;
                }
                else{
                    if(n > m)  answer = 1;
                }
                break;
        }
        
        return answer;
    }
}