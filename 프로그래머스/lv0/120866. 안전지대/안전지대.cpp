#include <string>
#include <vector>
#include <queue>
using namespace std;

int visited[101][101] = {0,};
int dx[8] = {0, 1,  1,  1,  0, -1, -1,  -1 };
int dy[8] = {-1, -1, 0,  1,  1,  1,  0,   -1 };
int solution(vector<vector<int>> board) {
    int answer = 0;
    queue<pair<int,int>> p;
    for(int i=0;i<board.size();i++)
    {
        for(int j=0;j<board[0].size();j++)
        {
            if(board[i][j] == 1)
                p.push({i,j});
        }
    }
    while(p.size()>0)
    {
        int y = p.front().first;
        int x = p.front().second;
        p.pop();
        for(int i=0;i<8;i++)
        {
            int r = y + dy[i];
            int c = x + dx[i];
            if(r>=board.size()||c>=board[0].size()||r <0||c<0)
                continue;
            board[r][c] = 2;
        }
    }
    for(int i=0;i<board.size();i++)
    {
        for(int j=0;j<board[0].size();j++)
        {
            if(board[i][j] == 0)
                answer++;
        }
    }
    
    
    return answer;
}