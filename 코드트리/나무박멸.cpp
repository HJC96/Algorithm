#include <iostream>
#define max(a,b) ((a)>(b)?(a):(b))

using namespace std;
int n,m,k,c;

int map[21][21]={0,};

int dx[4] = {-1, 0, 1, 0};   int dy[4] = {0, 1, 0, -1};
int dx2[4] = {-1, 1, 1, -1}; int dy2[4] = {1, 1, -1, -1};

int answer=0;
struct wall
{
    int x,y;
}w[400];
int w_cnt=0;
void input()
{
    scanf("%d %d %d %d", &n,&m,&k,&c);
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            scanf("%d", &map[i][j]);
            if(map[i][j]==-1)
            {
                w[w_cnt].x = i;
                w[w_cnt++].y = j;
            }
        }
    }
}


void tree_grow()
{
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(map[i][j] <= 0)
                continue;
            int x = i;
            int y = j;
            int tree_num=0;
            for(int k=0;k<4;k++)
            {
                int cur_x = x +dx[k];
                int cur_y = y +dy[k];
                if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y> n)
                    continue;
                if(map[cur_x][cur_y] > 0)
                    tree_num++;
            }
            map[i][j]+=tree_num;
        }
    }
}
void tree_spread()
{
    int tmp_tree[21][21] = {0,};
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            int tree_num=0;

            if(map[i][j] > 0)
            {

                for(int k=0;k<4;k++)
                {
                    int cur_x = i + dx[k];
                    int cur_y = j + dy[k];
                    if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y> n)
                        continue;
                    if(map[cur_x][cur_y] == 0) // 다른 나무, 제초제, 벽 없는 곳 제초제 고려 필요
                        tree_num++;
                }
            
                for(int k=0;k<4;k++)
                {
                    int cur_x = i + dx[k];
                    int cur_y = j + dy[k];
                    if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y> n)
                        continue;
                    if(map[cur_x][cur_y] == 0) // 다른 나무, 제초제, 벽 없는 곳 제초제 고려 필요
                        tmp_tree[cur_x][cur_y] += int(map[i][j]/tree_num);
                }
            }
        }
    }
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            map[i][j] += tmp_tree[i][j];
        }
    }
}
int search(int x, int y)
{
    int i=0;
    int res = map[x][y];
    int dir[4] ={0,};
    for(int j=0;j<n*4;j++)
    {
        if(j%4 == 0) i++;
        if(i >k)
            break;
        int cur_x = x + dx2[j%4]*i;
        int cur_y = y + dy2[j%4]*i;

        if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y > n || (dir[j%4]==1))
            continue;
        if(map[cur_x][cur_y] <= 0 ) // 빈칸 로직 생각필요
        {
            dir[j%4]=1;
            continue;
        }
        res += map[cur_x][cur_y]; 
    }
    return res;    
}
void kill_tree(int x, int y)
{
    int i=0;
    //answer += map[x][y];
    map[x][y] = -c-1;
    int dir[4] ={0,};
    for(int j=0;j<n*4;j++)
    {
        if(j%4 == 0) i++;
        if(i >k)
            break;
        int cur_x = x + dx2[j%4]*i;
        int cur_y = y + dy2[j%4]*i;

        if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y> n || (dir[j%4]==1))
            continue;
        if(map[cur_x][cur_y] <= 0) // 빈칸 로직 생각필요
        {
            map[cur_x][cur_y] = -c-1;
            dir[j%4]=1;
            continue;
        }
        //answer += map[cur_x][cur_y];
        map[cur_x][cur_y] = -c-1; // temp 99 
            
    }
}
void map_setting()
{
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(map[i][j] < 0)
                map[i][j]++;
        }
    }
    for(int i=0;i<w_cnt;i++)
    {
        map[w[i].x][w[i].y] = -1;
    }
}
void find_pos()
{
    int max_value=0;
    int max_i = 0;
    int max_j = 0;
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(map[i][j] <=0 )
                continue;
            int tmp = search(i,j);
            if(max(tmp, max_value) >max_value)
            {
                max_value = tmp;
                max_i = i;
                max_j = j;
            }

        }
    }
    //cout << max_value<< " " << max_i << max_j <<endl;
    answer += max_value;
    kill_tree(max_i,max_j);

}


int main() {
    input();
    for(int i=1;i<=m;i++)
    {
        if(i>=2)
            map_setting();
        tree_grow();
        tree_spread();
        find_pos();

    }

    cout << answer;
    return 0;
}
