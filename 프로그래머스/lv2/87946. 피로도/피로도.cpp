#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
bool visited[8] = {false,};
int answer = -1;
void dfs(int hp, int cur, vector<vector<int>> dungeons, int level){
    if(!visited[cur]){
        visited[cur] = true;
        hp -= dungeons[cur][1];
        for(int i=0;i<dungeons.size();i++){  
            if(visited[i])    continue;
            if(hp-dungeons[i][0] >= 0)
                dfs(hp, i, dungeons, level+1);
        }
        visited[cur] = false;
    }
    answer = max(answer,level);
}

int solution(int k, vector<vector<int>> dungeons) {
    for(int i=0;i<dungeons.size();i++){
        dfs(k, i, dungeons, 1);
    }
    return answer;
}
