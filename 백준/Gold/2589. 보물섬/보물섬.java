import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        char[][] graph = new char[r+1][c+1];  // r+1, c+1 대신 정확한 크기 사용

        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();  // 문자열을 분할하지 않고 직접 읽음
            for (int j = 0; j < c; j++) {
                graph[i][j] = tmp.charAt(j);  // 문자열에서 직접 문자 추출
            }
        }

        int answer = 0;
        boolean [][]visited;
        int [][] dist;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(graph[i][j] == 'W') continue;
                visited = new boolean[r+1][c+1];
                dist = new int[r+1][c+1];
                visited[i][j] = true;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                while (!q.isEmpty()){
                    int[] cur = q.poll();
                    visited[cur[0]][cur[1]] = true;
                    for(int k=0;k<4;k++){
                        int newX = cur[0] + dx[k];
                        int newY = cur[1] + dy[k];
                        if(newX < 0 || newY < 0 || newX >= r|| newY >= c) continue;
                        if(graph[newX][newY] == 'W') continue;
                        if(visited[newX][newY]) continue;
                        visited[newX][newY] = true;
                        q.add(new int[]{newX, newY});
                        dist[newX][newY] = dist[cur[0]][cur[1]] + 1;
                        answer = Math.max(dist[newX][newY], answer);
                    }
                }
            }
        }



        System.out.println(answer);
    }
}
/*
class Position{
    int x;
    int y;
    int l;
    Position(int x, int y, int l){
        this.x = x;
        this.y = y;
        this.l = l;
    }
}
*/