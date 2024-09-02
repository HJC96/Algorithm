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
        char graph[][] = new char[r+1][c+1];
        for(int i=0;i<r;i++){
            String[] tmp = br.readLine().split("");
            for(int j=0;j<c;j++){
                graph[i][j] = tmp[j].charAt(0);
            }
        }

        int answer = 0;
        boolean [][]visited;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(graph[i][j] == 'W') continue;
                visited = new boolean[r+1][c+1];

                Queue<Position> q = new LinkedList<>();
                q.offer(new Position(i,j, 0));
                visited[i][j] = true;
                while (!q.isEmpty()){
                    Position cur = q.poll();
                    visited[cur.x][cur.y] = true;
                    for(int k=0;k<4;k++){
                        int newX = cur.x +dx[k];
                        int newY = cur.y +dy[k];
                        if(newX < 0 || newY < 0 || newX >= r|| newY >= c) continue;
                        if(graph[newX][newY] == 'W') continue;
                        if(visited[newX][newY]) continue;
                        visited[newX][newY] = true;
                        q.add(new Position(newX, newY, cur.l+1));
                    }
                    answer = Math.max(answer, cur.l);
                }

            }
        }



        System.out.println(answer);
    }
}

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
