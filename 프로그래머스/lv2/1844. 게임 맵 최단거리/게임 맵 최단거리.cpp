#include <vector>
#include <iostream>
#include <queue>
#define max(a,b) ((a) > (b) ? (a) : (b))
#define min(a,b) ((a) > (b) ? (b) : (a))
#define pr pair<int,int>
#define x first
#define y second

using namespace std;

int n,m;

/*
void BFS(queue<POS> &q, POS p, vector<vector<int> > maps)
{
    if(maps[min(p.x+1,m)][p.y] == 1)
    {
        q.push({p.x+1,p.y, p.level+1});   
    }    

    if(maps[max(0, p.x-1)][p.y] == 1)
	{
		q.push({p.x-1,p.y,p.level+1});
	}
    
    if(maps[p.x][min(p.y+1, n)] == 1)
	{
		q.push({p.x,p.y+1,p.level+1});
	}
    
    if(maps[p.x][max(0, p.y-1)] == 1)
	{
		q.push({p.x,p.y-1,p.level+1});
	}
}*/
int solution(vector<vector<int> > maps)
{
    queue<pr> q;
    q.push({0,0});
    m = maps.size()-1;
    n = maps[0].size()-1;
    int **dp = new int*[maps.size()];
    for(int i=0;i<maps.size();i++)
        dp[i] = new int[maps[0].size()];
    
    dp[0][0] = 1;
    maps[0][0] = 0;
    while(q.size()>0)
    {
        pr pos = q.front();
        if(pos.x == m && pos.y == n)
            return dp[pos.x][pos.y];
        
        q.pop();
        //maps[pos.x][pos.y] = 0;
        
        if(maps[min(pos.x+1,m)][pos.y] == 1)
        {
            maps[min(pos.x+1,m)][pos.y] = 0;
            q.push({pos.x+1,pos.y});   
            dp[pos.x+1][pos.y] = dp[pos.x][pos.y] + 1;
        }    

        if(maps[max(0, pos.x-1)][pos.y] == 1)
	    {
            maps[max(0, pos.x-1)][pos.y] =0;
		    q.push({pos.x-1,pos.y});
            dp[pos.x-1][pos.y] = dp[pos.x][pos.y] + 1;
	    }
    
        if(maps[pos.x][min(pos.y+1, n)] == 1)
	    {
            maps[pos.x][min(pos.y+1, n)] = 0;
	    	q.push({pos.x,pos.y+1});
            dp[pos.x][pos.y+1] = dp[pos.x][pos.y] + 1;
	    }
    
        if(maps[pos.x][max(0, pos.y-1)] == 1)
	    {
            maps[pos.x][max(0, pos.y-1)] = 0;
		    q.push({pos.x,pos.y-1});
            dp[pos.x][pos.y-1] = dp[pos.x][pos.y] + 1;
	    }
    }
    return -1;
}