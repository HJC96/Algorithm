#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int result = 0;
int visited[4] = {0,};
vector<string> baby = {"aya", "ye", "woo", "ma"};
void solve(string st, vector<string> bab)
{
    while(find(bab.begin(),bab.end(),st) != bab.end())
    {
        result++;
        bab.erase(find(bab.begin(),bab.end(),st));
    }
    for(int i=0;i<baby.size();i++)
    {
        if(visited[i] == 1)
            continue;
        visited[i] = 1;
        solve(st+baby[i],bab);
        visited[i] = 0;
    }
    return ;
}
int solution(vector<string> babbling) {
    for(int i=0;i<baby.size();i++)
    {
        visited[i] = 1;
        solve(baby[i], babbling);
        visited[i] = 0;
    }
    return result;
}