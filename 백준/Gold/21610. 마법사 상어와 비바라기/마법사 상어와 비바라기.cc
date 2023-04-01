#include <iostream>
#include <vector>
using namespace std;

// class Rain_Cloud
// {
//     public:
//         int r1, c1;
//         int r2, c2;
//         int r3, c3;
//         int r4, c4;
// };

// class point
// {
//     int r,c;
// };

int N, M;
int map[51][51] = {0,};
int table[101][2];
int dx[8] = {-1, -1, 0, 1, 1,  1,  0,  -1};
int dy[8] = { 0, -1,-1,-1, 0,  1,  1 ,  1};
int visited[51][51] = {0,};
//Rain_Cloud cld;
vector<pair<int,int>> pos;
void init()
{
    scanf("%d %d", &N, &M);
    getchar();
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++){
            scanf("%d",&map[i][j]);
            getchar();
        }
    }
    for(int i=0;i<M;i++)
    {
        scanf("%d %d",&table[i][0],&table[i][1]);
        getchar();
    }
    pos.push_back({N-2, 0});
    pos.push_back({N-2, 1});
    pos.push_back({N-1, 0});
    pos.push_back({N-1, 1});
    
}


void move_cld(int num)
{
    int d = table[num][0];
    int s = table[num][1];

    for(auto& point:pos)
    {
        int y = point.first  ;
        int x = point.second ;
        for(int i=0;i<s;i++)
        {
            y += dy[d-1];
            x += dx[d-1];
            y = (y + N)%N;
            x = (x + N)%N;
            
        }
        point.first  = y;
        point.second = x;
        visited[y][x] = 1;
    }
}

void rain()
{
    for(auto point:pos)
    {
        map[point.first][point.second]++;
    }
}

void water_bug()
{
    for(auto& point:pos)
    {
        for(int i=1;i<8;i+=2)
        {
            int y = point.first  ;
            int x = point.second ;
            y += dy[i];
            x += dx[i];
            if(y >= N)          continue;
            else if(y < 0)      continue;
            else if(x >= N)     continue;
            else if(x < 0)      continue;
            if(map[y][x] > 0)
            {
                map[point.first][point.second]++;
            }
        }

    } 
}

void set_cloud()
{
    pos.clear();
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        {
            if(visited[i][j] == 1)
            {
                visited[i][j] = 0;
            }
            else
            {
                if(map[i][j]>=2)
                {
                    map[i][j]-=2;
                    pos.push_back({i,j});
                }
            }
        }
    }    
}
int find_ans()
{
    int ans=0;
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
            ans += map[i][j];
    }
    return ans;
}
int main()
{
    int answer =0;
    init();
    for(int i=0;i<M;i++)
    {
        move_cld(i);
        rain();
        water_bug();
        set_cloud();   
    }
    answer = find_ans();   
    cout <<answer;
}
