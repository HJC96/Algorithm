import java.io.*;
import java.util.*;

class Solution {
    List<Set<Integer>> sets = new ArrayList<>();

    public int solution(int N, int number) {
        int answer = -1;
        String tmp = "";
        for(int i=0;i<=8;i++){
            sets.add(new HashSet<>());
            if(i>=1){
                tmp += N;
                sets.get(i).add(Integer.parseInt(tmp));        
            }
        }
        sets.get(0).add(0);
        
        for(int i=2;i<=8;i++){
            for(int j=1;j<i;j++){
                for(int cur:sets.get(i-j)){
                    for(int val:sets.get(j)){
                        sets.get(i).add(cur+val);
                        sets.get(i).add(cur-val);
                        sets.get(i).add(cur*val);
                        if(val!=0)
                            sets.get(i).add(cur/val);
                        // sets.get(i).add(cur*10 + val);
                    }
                }
            }
        }
        for(int i=0;i<=8;i++){
            if(sets.get(i).contains(number)) {answer = i; break;}
        }

        return answer;
    }
}