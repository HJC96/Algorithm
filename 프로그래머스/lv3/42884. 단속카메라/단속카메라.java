import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        List<Pair> lists = new ArrayList<>();
        int answer = 0;
        for(int[] route: routes){
            Pair pair = new Pair(route[0],route[1]);
            lists.add(pair);
        }
        Collections.sort(lists, (a,b) -> {
            return Integer.compare(a.end,b.end);
        });
        int length = lists.size();
        boolean[] visited = new boolean[length];
        
        for(int i=0;i<length;i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            for(int j=i;j<length-1;j++){
                if(lists.get(i).end >= lists.get(j+1).start){
                    visited[j+1] = true;
                }
            }
            answer++;
        }
        
        return answer;
    }
}

class Pair{
    int start;
    int end;
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}