#include <iostream>
#include <vector>
#define max(a,b) ((a)>(b)?(a):(b))

using namespace std;

int N,M;

int graph[9][9] = {0,};
int answer = -1;
int dx[4] = {0,1,0,-1};
int dy[4] = {-1,0,1,0};


vector<pair<int,int>> pos;
vector<pair<int,int>> virus;
void input()
{
    // init
    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            graph[i][j] = -1;
        }
    }
    // input
    scanf("%d %d",&N,&M);
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<M;j++)
        {
            scanf("%d", &graph[i][j]);
        }
    }
    
}

void set_pos()
{
    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            if(graph[i][j] == 0)
                pos.push_back({i,j});
            else if(graph[i][j] == 2)
                virus.push_back({i,j});
        }
    }
}

void set_wall(int cp[9][9], vector<int> v)
{
    // copy wall
    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            cp[i][j] = graph[i][j];
        }
    }
    cp[pos[v[0]].first][pos[v[0]].second] = 1;
    cp[pos[v[1]].first][pos[v[1]].second] = 1;
    cp[pos[v[2]].first][pos[v[2]].second] = 1;


}

void bfs(int cp[9][9])
{
    vector<pair<int,int>> temp_virus = virus;
    
    while(temp_virus.size()>0)
    {
        int y = temp_virus[0].first;
        int x = temp_virus[0].second;
        temp_virus.erase(temp_virus.begin());
        
        for(int i=0;i<4;i++)
        {
            int cur_y = y + dy[i];
            int cur_x = x + dx[i];
            if(cur_x<0 || cur_y <0 || cur_x>=M || cur_y>=N || cp[cur_y][cur_x] == 1)
                continue;
            if(cp[cur_y][cur_x] == 0)
            {
                temp_virus.push_back({cur_y,cur_x});
                cp[cur_y][cur_x] = 2;
            }
        }
    }

}

int find_ans(int cp[9][9])
{
    int tmp_answer = 0;
    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            if(cp[i][j] == 0)
            {
                tmp_answer++;
            }
        }
    }
    return tmp_answer;
}
int main()
{
    input();
    set_pos();
    vector<vector<int>> vv;
    vector<int> tmp;
    for(int i=0;i<pos.size();i++)
    {
        for(int j=i+1;j<pos.size();j++)
        {
            for(int k=j+1;k<pos.size();k++)
            {
                tmp.push_back(i);
                tmp.push_back(j);
                tmp.push_back(k);
                vv.push_back(tmp);
                tmp.clear();
            }
        }
    }

    for(int i=0;i<vv.size();i++)
    {
        int copy_wall[9][9] = {0,};
        set_wall(copy_wall,vv[i]);
        bfs(copy_wall);
       /*
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
                cout << copy_wall[i][j];
            cout << endl;
        }
        cout << endl;
        */
        //bfs(copy_wall);
        answer = max(find_ans(copy_wall),answer);
    }
    cout << answer;
}
