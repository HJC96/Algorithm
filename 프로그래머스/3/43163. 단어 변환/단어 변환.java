import java.io.*;
import java.util.*;

class Solution {
     
    public int bfs(String begin, String target, String[] words){
        int ans = 0;
        Queue<Pair<String, Integer>> que = new LinkedList<>();
        Map<String,Boolean> visited = new HashMap<>();
        que.add(new Pair(begin, 0));
        
        for (String word : words) {
            visited.put(word, false);
        }
        
        while(!que.isEmpty()){
            Pair<String,Integer> p = que.poll();
            visited.put(p.left, true);
            if(p.left.equals(target)) return (int)p.right;
            else{
                for(String word:words){
                     if(oneCharDiff(p.left,word) && !visited.get(word)){
                         que.add(new Pair(word,p.right+1));
                    }
                }
            }
}
        
        return ans;
    }
    
    boolean oneCharDiff(String str1, String str2){
        int cnt=0;
        for(int i=0;i<str1.length();i++){
            if(cnt>=2) return false;
            if(str1.charAt(i) == str2.charAt(i)) continue;
            else cnt++;
        }
        return cnt == 1;
    }



    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin,target,words);
        return answer;
    }     
}

class Pair<I, E>{
    I left;
    E right;
    
    public Pair(I left, E right){
        this.left = left;
        this.right = right;
    
    }
}