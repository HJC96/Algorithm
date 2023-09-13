import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> set = new ArrayList<>();
        String num="";
        for(int i=0;i<=8;i++){
            set.add(new HashSet<>());
            if(i>=1)
                set.get(i).add(Integer.parseInt(num));
            num+=N;
        }
        
        for(int i=2;i<=8;i++){
            for(int j=1;j<=i-1;j++){
                for(int k:set.get(j)){
                    for(int l:set.get(i-j)){
                       set.get(i).add(k+l);
                       set.get(i).add(k-l);
                       set.get(i).add(k*l);
                       if(l !=0)
                        set.get(i).add(k/l);
                    }
               }
            }
        }
        
        for(int i=1;i<=8;i++){
            if(set.get(i).contains(number)) return i;
        }
                    
        
        
        
        return -1;
    }
}

/*
1. 5 세개로 만들 수 있는 수...
5 1개 만들수 있는 경우 + 2개로 만들 수 있는 경우의 수







*/

