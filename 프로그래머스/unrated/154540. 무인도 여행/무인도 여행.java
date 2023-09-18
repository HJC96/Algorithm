import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        
        List<Integer> ans = new ArrayList<>();
        int [][] graph = new int[maps.length][maps[0].length()];
        boolean [][] visited = new boolean[maps.length][maps[0].length()];
        /*Make Graph*/
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j) == 'X') graph[i][j] = -1;
                else                         graph[i][j] = maps[i].charAt(j) - '0';
            }
        }
        Queue<Pair> que = new LinkedList<>();
        for(int i=0;i<maps.length;i++){
            
            for(int j=0;j<maps[0].length();j++){
                if(visited[i][j] == true) continue;
                else{
                    int tmpAns= 0;
                    if(graph[i][j] > 0){
                        Pair p = new Pair(i,j);
                        que.add(p);
                        while(!que.isEmpty()){
                            Pair cur = que.poll();
                            if(visited[cur.y][cur.x] == true) continue;
                            tmpAns += graph[cur.y][cur.x];
                            visited[cur.y][cur.x] = true;
                            System.out.println();
                            if(cur.y+1 < maps.length && graph[cur.y+1][cur.x] > 0){
                                Pair pp = new Pair(cur.y+1,cur.x);
                                que.add(pp);
                            }
                            if(cur.x+1 < maps[0].length() && graph[cur.y][cur.x+1] > 0){
                                Pair pp = new Pair(cur.y,cur.x+1);
                                que.add(pp);
                            }
                            if(cur.x-1 >=0 && graph[cur.y][cur.x-1] > 0){
                                Pair pp = new Pair(cur.y,cur.x-1);
                                que.add(pp);
                            }
                            if(cur.y-1 >=0 && graph[cur.y-1][cur.x] > 0){
                                Pair pp = new Pair(cur.y-1,cur.x);
                                que.add(pp);
                            }
                        }
                        ans.add(tmpAns);
                    }
                }
            }
        }
        int idx=0;
        if(ans.size() == 0) return new int[]{-1};
        else{
            int[] answer = new int[ans.size()];
            for(int i:ans) answer[idx++] = i;
            Arrays.sort(answer);
            return answer;
        }
    }
}
class Pair{
    int y;
    int x;
    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }
}
/*
1. Parse String Make Graph
2. use bfs -> do not forget to seperate it
3. sort

*/