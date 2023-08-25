import java.io.*;
import java.util.*;

class Solution {
    int [][] dp ; int target_x;
    int [][] pud; int target_y;
    int []dx = {1, 0};
    int []dy = {0, 1};
    int answer =0;
    public void bfs(int y, int x){
        Queue<Coordinate> que = new LinkedList<>();

        que.add(new Coordinate(y,x,0L));
        dp[0][0] = 0;
        while(!que.isEmpty()){
            Coordinate cur_coordinate = que.poll();
            if(cur_coordinate.x == target_x && cur_coordinate.y == target_y) {
                // if(Math.min((int)((cur_coordinate.value-1)%1000000007), dp[cur_coordinate.y][cur_coordinate.x]) == dp[cur_coordinate.y][cur_coordinate.x])
                    answer++;
                    
            }

                for(int i=0;i<2;i++){
                    int cur_x = cur_coordinate.x + dx[i];
                    int cur_y = cur_coordinate.y + dy[i];

                    if(cur_x < 0 || cur_y < 0 || cur_x > target_x || cur_y > target_y) continue;
                    if(dp[cur_y][cur_x] == -1) continue;

                    if(dp[cur_y][cur_x] > cur_coordinate.value+1) {
                        dp[cur_y][cur_x] = (int)(cur_coordinate.value + 1)%1000000007;
                        que.add(new Coordinate(cur_y,cur_x,cur_coordinate.value+1));
                    }
                }
            }
        }

    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = 1000000007;
            }
        }
        for(int []p:puddles) {
            dp[p[1]-1][p[0]-1] = -1;
        }
        target_x = m-1;
        target_y = n-1;

        pud = puddles;
        bfs(0,0);
        return answer;
    }
}

class Coordinate{
    int x;
    int y;
    Long value;
    public Coordinate(int y, int x, Long value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
// class Pair<I,E>{
//     I left;
//     E right;
//     public Pair(I left, E right){
//         this.left = left;
//         this.right = right;
//     }
// }