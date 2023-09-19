import java.io.*;
import java.util.*;

class Main {
    /* 우, 하, 좌, 상 */
    static int []dx = new int[]{1, 0 , -1, 0};
    static int []dy = new int[]{0, 1 , 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] lineArray = line.split(" ");
        int rows = Integer.parseInt(lineArray[0]);
        int cols = Integer.parseInt(lineArray[1]);

        int goal_row = 0; int goal_col = 0;
        int[][] map = new int[rows][cols];


        /*
         * . : 0
         * D : 1
         * * : 2
         * S : 3
         * */

        Queue<Coordination> que = new LinkedList<>();
        List<Coordination> tmpList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            line = br.readLine();
            for (int j = 0; j < cols; j++) {
                if (line.charAt(j) == '.') map[i][j] = 0;
                else if (line.charAt(j) == '*') {
                    map[i][j] = 2;
                    Coordination pos = new Coordination(i, j, 0,0);
                    que.add(pos);
                }
                else if (line.charAt(j) == 'S') {
                    map[i][j] = 1;
                    Coordination pos = new Coordination(i, j, 0,1);
                    tmpList.add(pos);
                }
                else if (line.charAt(j) == 'D'){
                    map[i][j] = 3;
                    goal_row = i;
                    goal_col = j;
                }
                else if (line.charAt(j) == 'X'){
                    map[i][j] = 4;
                }
            }
        }
        for(Coordination c:tmpList) que.add(c);
        while(!que.isEmpty()){
            Coordination cd = que.poll();
            if(cd.y == goal_row && cd.x == goal_col && cd.type == 1){
                System.out.print(cd.t);
                return;
            }
            for(int i=0;i<4;i++){
                int curX = cd.x +dx[i];
                int curY = cd.y +dy[i];

                if(curX <0 || curX >= cols || curY < 0 || curY >= rows) continue;

                if(cd.type == 0) {
                    if(map[curY][curX] == 2 || map[curY][curX] == 3 ||  map[curY][curX] == 4) continue;
                    Coordination curPos = new Coordination(curY, curX, cd.t+ 1, cd.type);
                    map[curY][curX] = 2;
                    que.add(curPos);
                }
                else{
                    if(map[curY][curX] == 2 || map[curY][curX] == 1 ||map[curY][curX] == 4) continue;
                    Coordination curPos = new Coordination(curY, curX, cd.t+ 1, cd.type);
                    map[curY][curX] = 1;
                    que.add(curPos);
                }

            }
        }
        System.out.print("KAKTUS");
        return;
    }


}
/*
*  type: 0(Water)
*  type: 1(Dochi)
*
*/
class Coordination{
    int y;
    int x;
    int t;
    int type;

    public Coordination(int y, int x, int t, int type){
        this.y = y;
        this.x = x;
        this.t = t;
        this.type = type;
    }
}