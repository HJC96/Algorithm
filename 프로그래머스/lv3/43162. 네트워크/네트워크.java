import java.io.*;
import java.util.*;

class Solution {
    boolean[] visited;
    int[][] computer ;
    public void dfs(int num, int[] com){
        if(visited[num]==true) return;
        visited[num] = true;
        for(int i=0;i<com.length;i++){
            if(i == num) continue;
            if(com[i] == 1) dfs(i, computer[i]);
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0; visited = new boolean[computers[0].length];
        computer = computers;
        for(int i=0;i<visited.length;i++){
            if(visited[i] == false){
                dfs(i, computers[i]);
            }else{
                continue;
            }
            answer++;
        }
        return answer;
    }
}


