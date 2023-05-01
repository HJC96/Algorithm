#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>

using namespace std;

map<string, vector<pair<string,int>>> h;
int ticket_use = 0; vector<string> answer; bool flag = true;
void dfs(string cur_pos, vector<string> ans) {
    if (flag) {
        ans.push_back(cur_pos);

        if (ans.size() == ticket_use + 1) {
            answer = ans;
            flag = false;
            return;
        }
        if (h.count(cur_pos) <= 0) { return; }

        for (int idx = 0; idx < h[cur_pos].size(); idx++) {
            string next_pos = h[cur_pos][idx].first;
            int visited = h[cur_pos][idx].second;
                if (!visited) {
                    h[cur_pos][idx].second = 1;
                    dfs(next_pos, ans);
                    h[cur_pos][idx].second = 0;
                }
            }
        }
    }


vector<string> solution(vector<vector<string>> tickets) {

    for (auto elem : tickets) {
        if (h.count(elem[0]) > 0) { // if(h[elem[0]].size() > 0)를 사용하면 안됨. 키 'elem[0]'가 없는 경우 예외 발생 
            h[elem[0]].push_back({elem[1],0});
        }
        else {
            vector<pair<string,int>> tmp;
            tmp.push_back({elem[1],0});
            h.insert({ elem[0],tmp });
        }
    }

    for (auto& e : h) {
        sort(e.second.begin(),e.second.end());
        ticket_use += e.second.size();
    }
    vector<string> tmp;
    dfs("ICN", tmp);
    return answer;
}

