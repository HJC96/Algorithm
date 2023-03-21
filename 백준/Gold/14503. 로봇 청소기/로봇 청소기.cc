#include <iostream>

using namespace std;

class robot
{
    public:
        int x, y;
        int direct;
};


int map[50][50];
robot rbt;
int dx[4] = { 0, 1, 0, -1}; // N, E, S, W
int dy[4] = {-1, 0, 1,  0};
int N, M;
int ans = 0;

void init()
{
    scanf("%d %d", &N, &M);
    scanf("%d %d %d", &rbt.y, &rbt.x, &rbt.direct);
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<M;j++)
            scanf("%d", &map[i][j]);
    }
}

int sum()
{
    int s = 0;
    for(int i=0;i<51;i++)
        for(int j=0;j<51;j++)
            s += map[i][j];
    return s;
}

void clean()
{
    if(map[rbt.y][rbt.x] == 0)
    {
        map[rbt.y][rbt.x] = 2;
        ans++;
    }
}

int find_move()
{
    int res = 0;
    for(int i=0;i<4;i++)
    {
        int x, y;
        int cur_dir = rbt.direct;

        cur_dir = (cur_dir+3-i)%4;
        // worried about segfault
        x = rbt.x + dx[cur_dir];
        y = rbt.y + dy[cur_dir];

        if(y < 0 || y >=N || x < 0 || x >= M || (map[y][x] != 0))
            continue;
        else
        {
            rbt.x = x;
            rbt.y = y;
            rbt.direct = cur_dir;
            res = 1;
            break;
        }
    }
    return res;
}

int move1()
{
    int res = 1;
    int cur_dir = rbt.direct;
    int y = rbt.y + dy[(cur_dir + 2)%4];
    int x = rbt.x + dx[(cur_dir + 2)%4];

    if(map[y][x] == 1)  return 0;
    
    rbt.x = x;
    rbt.y = y;
    rbt.direct = cur_dir;
    return 1;
}


int main()
{
    init();
    while(1)
    {
        clean();        
        if(find_move() == 1) 
            continue;
        if(move1() == 0)
            break;
    }
    cout << ans;
}


/*
반례
7 7
4 2 1
1 1 1 1 1 1 1
1 0 0 0 1 0 1
1 0 1 1 0 0 1
1 0 0 0 0 1 1
1 0 0 1 0 0 1
1 0 0 0 0 0 1
1 1 1 1 1 1 1
*/