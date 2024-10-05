import java.io.*;
import java.util.*;

class Solution {
    private List<List<Integer>> g = new ArrayList<>();
    private static boolean[] visited = new boolean[201];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0;i<201;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<computers[0].length;i++){
            for(int j=0;j<computers[0].length;j++){
                if(i==j) continue;
                if(computers[i][j] == 1){
                    g.get(i).add(j);
                }
            }
        }
        for(int i=0;i<computers[0].length;i++){
            if(visited[i]) continue;
            dfs(i);
            answer++;
        }
        return answer;
    }
    
    private void dfs(int p){
        if(!visited[p]){
            visited[p] = true;
            for(int i:g.get(p)){
                dfs(i);
            }
        }
        return ;
    }
}