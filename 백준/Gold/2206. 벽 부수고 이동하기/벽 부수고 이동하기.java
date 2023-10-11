import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static final int MAX_N  = 1000;
    static int[][]graph;
    static int[][][]visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        graph = new int[MAX_N + 1][MAX_N + 1];
        visited = new int[MAX_N + 1][MAX_N + 1][2];

        String input;
        for (int i = 1; i <= N; i++) {
            input = br.readLine();
            for (int j = 1; j <= input.length(); j++) {
                graph[i][j] = (int)input.charAt(j-1) - 48;
            }
        }

        BFS();
        
        System.out.println(answer);

    }

    private static void BFS() {
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1,1,0));

        visited[1][1][0] = 1;
        while (!q.isEmpty()){
            Tuple t = q.poll();

            for(int i=0;i<4;i++){
                int curX = t.x + dx[i];
                int curY = t.y + dy[i];
                if(!Possible(curX, curY, t.crashed)) continue;
                if(curX == N && curY == M){
                    answer = visited[t.x][t.y][t.crashed] + 1;
                    return;
                }
                /* 앞에 벽이 없다면.... */
                if(graph[curX][curY] == 0){
                    q.add(new Tuple(curX, curY, t.crashed));
                    visited[curX][curY][t.crashed] = visited[t.x][t.y][t.crashed] + 1;
                }
                /* 앞에 벽이 있고, 벽 부수기를 안했다면 */
                else {
                    if (graph[curX][curY] == 1) {
                        if (t.crashed == 0) {
                            visited[curX][curY][1] = visited[t.x][t.y][0] + 1;
                            q.add(new Tuple(curX, curY, 1));
                        }
                        /* 앞에 벽이 있고, 벽 부수기를 했다면 */
                        else {
                            continue;
                        }
                    }
                }
            }
        }
        if(N == 1 && M == 1) answer = 1;
        else answer = -1;
    }

    private static boolean Possible(int curX, int curY, int crashed) {
        if(curX < 1 || curY < 1 || curX >=N+1 || curY >=M+1 || visited[curX][curY][crashed] >= 1) return false;
        else return true;
    }
}

class Tuple{
    int x;
    int y;
    int crashed;
    public Tuple(int x, int y, int crashed) {
        this.x = x;
        this.y = y;
        this.crashed = crashed;
    }
}
