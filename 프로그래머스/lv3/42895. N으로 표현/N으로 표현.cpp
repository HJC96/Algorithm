#include <string>
#include <queue>
#include <unordered_set>
#include <algorithm>

using namespace std;

int bfs(int N, int number) {
    queue<pair<int, int>> q;
    q.push({0, 0});
    unordered_set<int> visited;

    while (!q.empty()) {
        int curr_value = q.front().first;
        int curr_cnt = q.front().second;
        q.pop();

        if (curr_cnt > 8) {
            return -1;
        }
        
        if (curr_value == number) {
            return curr_cnt;
        }

        if (visited.find(curr_value) != visited.end()) {
            continue;
        }
        visited.insert(curr_value);

        int NN = 0;
        for (int i = 0; i < 8 - curr_cnt; ++i) {
            NN = NN * 10 + N;
            q.push({curr_value + NN, curr_cnt + i + 1});
            q.push({curr_value - NN, curr_cnt + i + 1});
            q.push({curr_value * NN, curr_cnt + i + 1});
            if (curr_value != 0) {
                q.push({curr_value / NN, curr_cnt + i + 1});
            }
        }
    }

    return -1;
}

int solution(int N, int number) {
    int answer = bfs(N, number);
    return answer;
}
