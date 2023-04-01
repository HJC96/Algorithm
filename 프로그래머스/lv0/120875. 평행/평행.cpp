#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int visited[4] = {0,};

int answer = 0;
void solve(vector<int> com, vector<int> last, vector<vector<int>> dots)
{
    if(com.size() == 2)
    {
        double dx1 = dots[com[0]][0] - dots[com[1]][0];
        double dy1 = dots[com[0]][1] - dots[com[1]][1];
        
        double dx2 = dots[last[0]][0] - dots[last[1]][0];
        double dy2 = dots[last[0]][1] - dots[last[1]][1];

        double gra1 = dy1/dx1;
        double gra2 = dy2/dx2;
        if(gra1 == gra2)
            answer = 1;
        
        return ;
    }
    for(int i=0;i<dots.size();i++)
    {
        vector<int> tmp = com;
        vector<int> tmp2 = last;
        if(visited[i] == 1)
            continue;
        tmp.push_back(i);
        visited[i] = 1;
        tmp2.erase(find(tmp2.begin(),tmp2.end(),i));
        solve(tmp, tmp2, dots);
        visited[i] = 0;
        
    }
}
int solution(vector<vector<int>> dots) {
    for(int i=0;i<dots.size();i++)
    {
        vector<int> sel;
        vector<int> last = {0, 1, 2, 3};
        sel.push_back(i);
        visited[i] = 1;
        last.erase(find(last.begin(),last.end(),i));
        solve(sel, last, dots);
        visited[i] = 0;

    }

    return answer;
}