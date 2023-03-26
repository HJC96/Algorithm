#include <iostream>
#include <cstdio>
#include <queue>
#include <vector>
#define abs(a) ((a)>(0)?(a):(-a))
using namespace std;
int N,L,R;


int graph[51][51] = {0,};
int determine[51][51] = {0,};
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int visited[51][51] = {0,};
bool is_changed = true;
int sum = 0;
vector<pair<int,int>> v;


void input()
{
    scanf("%d %d %d", &N, &L, &R);
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        {
            scanf("%d", &graph[i][j]);
        }
    }
}


void find(int r, int c)
{
    
    queue<pair<int,int>> q;
    q.push({r,c});
    visited[r][c] = 1;
    v.push_back({r,c});
    
    int size = 1;
    while(q.size()>0)
    {
        for(int i=0;i<4;i++)
        {
            int y = q.front().first + dy[i];
            int x = q.front().second + dx[i];
            if(x <0 || y<0 || x>=N || y>=N || visited[y][x])
                continue;
            int delta = abs((graph[y][x] - graph[q.front().first][q.front().second])); 
            
            if(delta >=L && delta <=R)
            {
                q.push({y,x});
                visited[y][x] =1;
                sum+=graph[y][x];
                v.push_back({y,x});
            }
        }
        q.pop();
    }
}


int main()
{
    input();
    int result = 0;
    while(is_changed)
    {
        is_changed = false;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(visited[i][j])
                    continue;
                v.clear();
                sum = graph[i][j];
                find(i,j);

                if(v.size() >=2)
                {
                    is_changed = true;
                    for(int i=0;i<v.size();i++)
                        graph[v[i].first][v[i].second] = sum/v.size();
                }
            }
        }
        if(is_changed)
            result++;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                //clear
                determine[i][j] = 0;
                visited[i][j] = 0;
            }
        }
    }

    printf("%d", result);
}
