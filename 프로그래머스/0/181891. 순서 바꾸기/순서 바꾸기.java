import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        for(int i=0;i<num_list.length;i++){
            if(i<n){
                answer.add(num_list[i]);
            }
            else{
                answer.add(idx++, num_list[i]);
            }
                
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}