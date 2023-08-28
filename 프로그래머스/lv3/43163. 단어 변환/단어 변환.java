import java.io.*;
import java.util.*;

class Solution {
    public boolean OneCharDiff(String source, String target){
    int length = source.length();
    int cnt=0;
    for(int i=0;i<length;i++){
        if(source.charAt(i) == target.charAt(i)){
            cnt++;
        }
    }
    
    return (length-cnt==1);
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Map<String, Boolean> visited = new HashMap<>();
        for(String word:words) visited.put(word,false);
        Queue<Pair<String,Integer>> que = new LinkedList<>();
        que.add(new Pair<>(begin,0));
        while(!que.isEmpty()){
            Pair<String,Integer> pair = que.poll();        
            visited.put(pair.left,true);
            if(pair.left.equals(target)){ answer = pair.right; break; }
            for(String word:words){
                if(!visited.get(word) &&OneCharDiff(pair.left,word)){
                    que.add(new Pair<>(word,pair.right+1));
                    visited.put(word,true);  
                }
            }
        }
        
        return answer;
    }
    
}

class Pair<L,R>{
    L left; R right;
    public Pair(L x, R y){
        this.left = x;
        this.right = y;
    }
}

