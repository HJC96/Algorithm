#include <iostream>
#include <queue>
#include <algorithm>
#pragma warning(disable:4996)

using namespace std;

int N, M;
int dist[16][16];
int map[16][16];
int dx[4] = { 0,-1,1,0 };
int dy[4] = { -1,0,0,1 };
struct Person
{
    int x, y, goal_x, goal_y;

}p[31];
void input()
{

    scanf("%d %d", &N, &M);
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            scanf("%d", &map[i][j]);
        }
    }
    for (int i = 1; i <= M; i++)
    {
        scanf("%d %d", &p[i].goal_y, &p[i].goal_x);
    }

}

void BFS(int x, int y)
{
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            dist[i][j] = 10000;
        }
    }
    queue<int> q;
    q.push(y), q.push(x); dist[y][x] = 0;
    while (!q.empty())
    { 
        int ny = q.front(); q.pop();
        int nx = q.front(); q.pop();
        for (int i = 0; i < 4; i++)
        {
            int cur_x = nx + dx[i];
            int cur_y = ny + dy[i];
            if (cur_x < 1 || cur_y < 1 || cur_x > N || cur_y > N)
                continue;
            if (map[cur_y][cur_x] == -1)
                continue;
            if (dist[cur_y][cur_x] != 10000)
                continue;
            dist[cur_y][cur_x] = dist[ny][nx] + 1;
            q.push(cur_y); q.push(cur_x);
        }
    }
}

void init_people(Person* p)
{
    BFS(p->goal_x, p->goal_y);
    
    int min_value = 10000; int min_i = 0, min_j = 0;
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            if (map[i][j] != 1)
                continue;
            if (dist[i][j] < min_value)
            {
                min_value = dist[i][j];
                min_i = i;
                min_j = j;
            }
        }
    }
    p->y = min_i; p->x = min_j; map[p->y][p->x] = -1;
}


void move_people(Person* p)
{
    if (p->x == p->goal_x && p->y == p->goal_y)
        return;


    BFS(p->goal_x, p->goal_y);

    //int min_value = 10000; int min_i = 0, min_j = 0;
    int min_value = 10000;
    int dir = -1;
    for (int i = 0; i < 4; i++)
    {
        int cur_x = p->x + dx[i];
        int cur_y = p->y + dy[i];
         
        if (cur_x < 1 || cur_y < 1 || cur_x > N || cur_y > N)
            continue;
    //    if (map[cur_y][cur_x] == -1)
    //        continue;
        if (dist[cur_y][cur_x] < min_value)
        {
    //        min_i = cur_y;
    //        min_j = cur_x;
            min_value = dist[cur_y][cur_x];
            dir = i;
        }
    }
    p->y += dy[dir];
    p->x += dx[dir];
    //p->y = min_i;
    //p->x = min_j;

}

void set_map(Person* p)
{
    if (p->x == p->goal_x && p->y == p->goal_y)
        map[p->y][p->x] = -1;
}

bool isFinished()
{
    for (int i = 1; i <= M; i++)
    {
        if (p[i].x != p[i].goal_x || p[i].y != p[i].goal_y)
            return false;
    }
    return true;
}



int main()
{
    input();
    int T = 0;
    while (!isFinished())
    {
        T++;
        
        for (int i = 1;i<T && i <= M; i++)
            move_people(&p[i]);

        for (int i = 1;i<T && i <= M; i++)
            set_map(&p[i]);

        if (T <= M)
            init_people(&p[T]);
    }
    cout << T;
}
