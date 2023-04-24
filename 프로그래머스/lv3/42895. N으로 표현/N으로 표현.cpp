#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
#include <unordered_set>

using namespace std;

int bfs(int num, int number){
    queue<pair<int,int>> q;
    q.push({0, 0});
    unordered_set<int> visited;

    while(!q.empty()){
        int front = q.front().first;
        int lv = q.front().second;
        q.pop();
        if(lv >8) return -1;
        if(front == number) {return lv;}

        if(visited.find(front) != visited.end()) continue;
        visited.insert(front);

        string tmp1 ="";
        for(int i=0;i<8-lv;i++){
            tmp1 += to_string(num);
            q.push({front+stoi(tmp1),lv+i+1});
            q.push({front-stoi(tmp1),lv+i+1});
            q.push({front*stoi(tmp1),lv+i+1});
            q.push({front/stoi(tmp1),lv+i+1});
        }
    }
}

int solution(int N, int number) {
    int answer = bfs(N, number);
    return answer;
}
