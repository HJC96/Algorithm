import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        
        List<Integer> lis = new ArrayList<>();
        int tmp=0;
        while(tmp+k<=n){
            tmp+=k;
            lis.add(tmp);
        }
        int[] answer = new int[lis.size()];
        for(int i=0;i<lis.size();i++){
            answer[i] = lis.get(i);
        }
        return answer;
    }
}