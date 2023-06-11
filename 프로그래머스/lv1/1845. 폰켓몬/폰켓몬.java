import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i:nums){
            if(hash.containsKey(i)){
                hash.put(i,hash.get(i)+1);
            }else{
                hash.put(i,1);
            }
        }
        
        return answer>hash.size()?hash.size():answer;
    }
}