#include <iostream>
#include <queue>
#include <stack>
#define MAX(a,b) ((a)>(b)?(a):(b))

using namespace std;

int table[400][5] = {0,};
int love_table[21][21]= {0,};
int blank_table[21][21]= {0,};
int ans_table[21][21]= {0,};
int visited[21][21]= {0,};

int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};
int N, m, m2;

void init()
{
    scanf("%d", &N);
    int num = N*N;
    for(int i=0;i<num;i++)
    {
        for(int j=0;j<5;j++)
            scanf("%d", &table[i][j]);
    }
}

void find_love(int r, int c, int num)
{
    int cnt = 0;
    for(int i=0;i<4;i++)
    {
        int y = r + dy[i];
        int x = c + dx[i];

        if(x <1 || y <1 || x >N || y>N)
            continue;
        if(ans_table[y][x] == table[num][1]) cnt++;
        if(ans_table[y][x] == table[num][2]) cnt++;
        if(ans_table[y][x] == table[num][3]) cnt++;
        if(ans_table[y][x] == table[num][4]) cnt++;
    }
    
    if(!visited[r][c])
    {
        love_table[r][c] = cnt;
        m = MAX(m, cnt);
    }
    else    love_table[r][c] = -1;
}

void find_blank(int r, int c)
{
    int cnt = 0;
    for(int i=0;i<4;i++)
    {
        int y = r + dy[i];
        int x = c + dx[i];

        if(x <1 || y <1 || x >N || y>N)
            continue;
        if(ans_table[y][x] == 0) cnt++; 
    }
    if(!visited[r][c])
    {
        blank_table[r][c] = cnt;
        m2 = MAX(m2, cnt);
    }
    else  blank_table[r][c] = -1;
}

int main()
{
    init();   
    int ans = 0;
    int cnt = N*N;

    while(cnt >0)
    {
        m = 0;
        m2 = 0;
        stack<pair<int,int>> s1;
        queue<pair<int,int>> s2;
        int stdID = table[N*N-cnt][0];
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=N;j++)
            {
                find_love(i, j, N*N-cnt);
                find_blank(i, j);
            }
        }

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=N;j++)
            {
                if(love_table[i][j] == m && !visited[i][j]){ 
                    s1.push({i,j});
                }
            }
        }

        if(s1.size()>1)
        {
            int topy ;
            int topx ;
            stack<pair<int,int>> blank;
            int blan = -1;

            while(s1.size()>0)
            {
                topy = s1.top().first;
                topx = s1.top().second;
        
                s1.pop();

                if(blank_table[topy][topx] >= blan)
                {
                    if(blank_table[topy][topx] == blan)
                        blank.push({topy, topx});
                    else
                    {
                        while(blank.size()>0)   blank.pop();
                        blank.push({topy, topx});
                    }
                    blan = blank_table[topy][topx];
                }
            }
            while(blank.size()>0)
            {
                topy = blank.top().first;
                topx = blank.top().second;

                blank.pop();
                if(!visited[topy][topx])
                {   
                    s2.push({topy,topx});
                }
            }
            if(s2.size()>0)
            {
                ans_table[s2.front().first][s2.front().second] = stdID;
                visited[s2.front().first][s2.front().second] = 1;
            }
            else
            {
                ans_table[topy][topx] = stdID;
                visited[topy][topx] = 1;    
            }
        }
        else
        {
            if(s1.size()>0)
            {
                ans_table[s1.top().first][s1.top().second] = stdID;
                visited[s1.top().first][s1.top().second] = 1;
            }
        }
        cnt-=1;

    }
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=N;j++)
            {
                int ct = 0;
                for(int k=0;k<4;k++)
                {
                    int y = i + dy[k];
                    int x = j + dx[k];

                    if(x <1 || y <1 || x >N || y>N)
                        continue;
                    int idx=0;
                    while(ans_table[i][j] !=table[idx][0]) idx++;

                    if(ans_table[y][x] == table[idx][1]) ct++;
                    if(ans_table[y][x] == table[idx][2]) ct++;
                    if(ans_table[y][x] == table[idx][3]) ct++;
                    if(ans_table[y][x] == table[idx][4]) ct++; 
                }
                if(ct == 1)
                    ans += 1 * 1;
                else if(ct == 2)
                    ans += 1 * 10;
                else if(ct == 3)
                    ans += 1 * 100;
                else if(ct == 4)
                    ans += 1* 1000;
            }
            
        }
    cout << ans;
}
