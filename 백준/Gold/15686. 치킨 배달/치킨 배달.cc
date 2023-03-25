#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define abs(a) ((a)>(0)?(a):(-a))
using namespace std;
int N, M;
int map[51][51] = {0,};

vector<vector<int>> coord;
vector<pair<int,int>> chick;
vector<pair<int,int>> home;
queue<pair<vector<int>,int>> que;

int ans = 51*51;

void init()
{
    scanf("%d %d", &N, &M);
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        {
            scanf("%d", &map[i][j]);    
            if(map[i][j] == 1)
                home.push_back({i,j});
            if(map[i][j] == 2)
                chick.push_back({i,j});
        }
    }
}

int sum(vector<int> choose)
{
    int s=0;
    for(int i=0;i<choose.size();i++)
        s+=choose[i];
    return s;
}

void Combi(vector<int> choose, int level)
{
    if(level == M)  {
        vector<vector<int>> tmp;
        for(int i=0;i<choose.size();i++)
        {
            vector<int> dis ;
            // 집 ~ 치킨집 거리
            for(int j=0;j<home.size();j++)
            {
                int x = home[j].first - chick[choose[i]].first;
                int y = home[j].second - chick[choose[i]].second;
                dis.push_back((abs(x) + abs(y)));
            } 
            tmp.push_back(dis);
        }
        
        vector<int> answer;
        for(int i=0;i<home.size();i++)
        {
            int val = 51*51;
            for(int j=0;j<tmp.size();j++)
            {
                val = min(tmp[j][i], val);
            }
            answer.push_back(val);
        }
        ans = min(ans, sum(answer));
    }
    else
    {
        for(int i=choose[choose.size()-1]+1;i<chick.size();i++)
        {
            vector<int> tmp = choose;
            tmp.push_back(i);
            Combi(tmp,level+1); 
        }
    }

}


int main()
{
    init();
    for(int i=0;i<chick.size();i++)
    {
        vector<int> tmp;
        tmp.push_back(i);
        Combi(tmp, 1);
    }
    cout << ans;
}
