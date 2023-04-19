#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int map[100][100];
int dist[100][100] = {0,};
int map_hor; int map_ver;
int dx[4] = {-1,0,1,0};
int dy[4] = {0,-1,0,1};

pair<int,int> r ;
pair<int,int> g ;
int level;
int bfs(int x, int y, int cur_level){
    queue<int> q;
    q.push(x); q.push(y);
    while(!q.empty())
    {
        x = q.front(); q.pop();
        y = q.front(); q.pop();
        if(map[x][y] == 3){
            return dist[x][y];
        }
        for(int i=0;i<4;i++){
            int cur_x = x + dx[i];
            int cur_y = y + dy[i];
            if(cur_x >= map_ver || cur_y >= map_hor || cur_x < 0 || cur_y < 0 || map[cur_x][cur_y] == 1) continue;
            while(1){
                if(cur_x >= map_ver || cur_y >= map_hor || cur_x < 0 || cur_y < 0 || map[cur_x][cur_y] == 1)
                    break;
            else{
                cur_x += dx[i];
                cur_y += dy[i];
            }
        }
        cur_x -= dx[i];
        cur_y -= dy[i];
        if(dist[cur_x][cur_y] == 0){
            dist[cur_x][cur_y] = dist[x][y] + 1;
            q.push(cur_x); q.push(cur_y);
        }      
    }
    }
    return -1;
}

void init(vector<string> board)
{
    map_ver = board.size();
    map_hor = board[0].size();
    for(int i=0;i<map_ver;i++){
        for(int j=0;j<map_hor;j++){
            if(board[i][j] == '.')      map[i][j] = 0;
            else if(board[i][j] == 'D') map[i][j] = 1;
            else if(board[i][j] == 'R') {map[i][j] = 2; r.first = i; r.second = j;}
            else if(board[i][j] == 'G') {map[i][j] = 3; g.first = i; g.second = j;}
        }
    }
    level=999999999;
}

int solution(vector<string> board) {
    init(board);
    int answer = bfs(r.first,r.second,0);
    return answer;
    
} 