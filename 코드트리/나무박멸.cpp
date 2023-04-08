#include <iostream>


using namespace std;
int n,m,k,c;
int map[21][21];
int dx[4]={-1,0,1,0}; int dy[4]={0,1,0,-1}; 
int dx2[4]={-1,1,1,-1}; int dy2[4]={1,1,-1,-1};
int answer=0;
struct Wall
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
            if(map[i][j] == -1)
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
            int tree_exists=0;
            // if tree exists
            if(map[i][j] > 0) 
            {
                for(int k=0;k<4;k++)
                {
                    int cur_x = i + dx[k];
                    int cur_y = j + dy[k];

                    if(cur_x > n || cur_y > n || cur_x < 1 || cur_y < 1)
                        continue;
                    if(map[cur_x][cur_y] > 0)
                        tree_exists++;
                }
            }
            map[i][j] += tree_exists;
        }
    }
}

void tree_breed()
{
    int tmp_map[21][21] ={0,};
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(map[i][j] >0)
            {
                int no_tree_counts=0;
                for(int k=0;k<4;k++)
                {
                    int cur_x = i + dx[k];
                    int cur_y = j + dy[k];

                    if(cur_x > n || cur_y > n || cur_x < 1 || cur_y < 1)
                        continue;
                    if(map[cur_x][cur_y] == 0)
                        no_tree_counts++;
                }

                for(int k=0;k<4;k++)
                {
                    int cur_x = i + dx[k];
                    int cur_y = j + dy[k];

                    if(cur_x > n || cur_y > n || cur_x < 1 || cur_y < 1)
                        continue;
                    if(map[cur_x][cur_y] == 0)
                        tmp_map[cur_x][cur_y] += map[i][j]/no_tree_counts; 
                }
            }
        }
    }

    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            map[i][j] += tmp_map[i][j];
        }
    } 
}

int search(int x, int y)
{
    int res = map[x][y];
    int dir[4] = {0,};
    for(int i=1;i<=k;i++)
    {
        for(int j=0;j<4;j++)
        {
            int cur_x = x+ dx2[j]*i;
            int cur_y = y+ dy2[j]*i;
            if(cur_x > n || cur_y > n || cur_x < 1 || cur_y < 1 || (dir[j] == 1) )
                continue;
            if(map[cur_x][cur_y] <= 0)
            {
                dir[j] = 1; 
                continue;
            }
            res += map[cur_x][cur_y];
        }
    }
    return res;
}
void tree_kill(int x,int y)
{
    int dir[4] = {0,};
    map[x][y] = -c-1;
    for(int i=1;i<=k;i++)
    {
        for(int j=0;j<4;j++)
        {
            int cur_x = x+ dx2[j]*i;
            int cur_y = y+ dy2[j]*i;
            if(cur_x > n || cur_y > n || cur_x < 1 || cur_y < 1 || (dir[j] == 1) )
                continue;
            if(map[cur_x][cur_y] <= 0)
            {
                dir[j] = 1;
                map[cur_x][cur_y] = -c-1; 
                continue;
            }
            map[cur_x][cur_y] = -c-1;
        }
    }
}

void map_setting()
{
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(map[i][j]<0)
                map[i][j]++;
        }
    }
}
void wall_setting()
{
    for(int i=0;i<w_cnt;i++)
    {
        map[w[i].x][w[i].y] = -1;
    }
}
void find_pos()
{
    int max_value=0;
    int max_i=0; int max_j=0;
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(map[i][j] >0)
            {
                int tmp = search(i,j);
                if(tmp > max_value)
                {
                    max_value = tmp;
                    max_i = i; max_j = j;
                }
            }
        }
    }
    answer += max_value;
    //tree_kill
    tree_kill(max_i,max_j);
    // after kill tree, set the map
    map_setting();
    wall_setting();
    
}


int main() {

    input();
    for(int i=1;i<=m;i++)
    {

        tree_grow();
        tree_breed();
        find_pos();

    }
    cout << answer;
    return 0;
}
