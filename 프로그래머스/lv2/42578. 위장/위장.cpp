#include <string>
#include <vector>
#include <map>
#include <set>

#define pr string,vector<string>
using namespace std;

int solution(vector<vector<string>> clothes) {
    map<pr> m;
    int answer = 1;
    set<string> filter;
    for(int i=0;i<clothes.size();i++)
    {
        filter.insert(clothes[i][1]);
    }
    for(auto f:filter)
    {
        vector<string> word;
        for(int i=0;i<clothes.size();i++)
        {
            if(clothes[i][1] == f)
                word.push_back(clothes[i][0]);
        }
        m[f] = word;
        answer = 1 * (word.size()+1) *answer;
    }
    // next ?
    return answer-1;
}