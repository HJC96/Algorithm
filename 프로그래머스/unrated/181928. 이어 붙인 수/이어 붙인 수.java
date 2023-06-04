import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd ="";
        String even ="";
        for(int i=0;i<num_list.length;i++){
            if(num_list[i]%2 != 0)
                odd += num_list[i];
            else
                even += num_list[i];
        }
        answer = Integer.parseInt(odd) + Integer.parseInt(even) ;
        
        return answer;
    }
}