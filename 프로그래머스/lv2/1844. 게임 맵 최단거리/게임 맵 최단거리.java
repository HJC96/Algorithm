import java.io.*;
import java.util.*;

class Solution {
    int targetX; int targetY;
    int [][]map; int answer=99999999;
    int []dx = {1, 0, -1, 0};
    int []dy = {0, -1, 0, 1};
    void bfs(int x, int y){
        // if(map[x][y] != 1)  return ;
        // map[x][y] = 1;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0,0));

        while(!que.isEmpty()){
            Pair pair = que.poll();
            x = pair.x; y = pair.y;
            if(pair.x==targetX && pair.y==targetY) {
                answer = Math.min(map[x][y],answer);
                return;
            }
            for(int i=0;i<4;i++){
                int cur_x = x+dx[i];    int cur_y = y+dy[i];
                if(cur_x <0 || cur_x > targetX || cur_y <0 || cur_y > targetY) continue; // 좌표 벗어난 경우
                if(map[cur_x][cur_y] !=1 ) continue; // 1로만 잡으면 한번 갔던길을 다시 갈 수 없음///
                // if(map[cur_x][cur_y] <= map[x][y] +1) map[cur_x][cur_y] = map[x][y] +1;
                map[cur_x][cur_y] = map[x][y] +1;

                que.add(new Pair(cur_x, cur_y));
                
            }
        }
    }
    
    
    public int solution(int[][] maps) {
        map = maps;
        targetX = maps.length-1;
        targetY = maps[0].length-1;
        bfs(0,0);
        
        if(answer == 99999999) answer = -1;
        return answer;
    }
}


class Pair{
    int x; int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
