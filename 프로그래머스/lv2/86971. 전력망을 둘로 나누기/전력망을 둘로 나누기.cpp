#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<vector<int>> graph(101);

int dfs(int node, bool visited[]) {
    if(visited[node]) return 0;
    visited[node] = true;
    int count = 1;

    for (int i=0;i<graph[node].size();i++) {
        count += dfs(graph[node][i], visited);
    }

    return count;
}

int solution(int n, vector<vector<int>> wires) {
    for (auto elem : wires) {
        graph[elem[0]].push_back(elem[1]);
        graph[elem[1]].push_back(elem[0]); 
    }

    
    int min_diff = n;  
    for (auto elem : wires) {
        graph[elem[0]].erase(find(graph[elem[0]].begin(), graph[elem[0]].end(),elem[1]));
        graph[elem[1]].erase(find(graph[elem[1]].begin(), graph[elem[1]].end(),elem[0]));
        bool visited[101] = {false,};
        min_diff = min(min_diff, abs(n - 2*dfs(1, visited)));
        graph[elem[0]].push_back(elem[1]);
        graph[elem[1]].push_back(elem[0]);
    }

    return min_diff;
}
