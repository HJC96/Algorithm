#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string s) {
    int answer = 0;
    int idx=0;
    int find = 0;
    vector<string> ans;
    while(find<s.size())
    {
        idx = find;
        while(find < s.size() && s[find] != ' ') find++;
        ans.push_back(s.substr(idx,find-idx));
        find++;
    }
    int i=0;
    while(i<ans.size())
    {
        if(ans[i] == "Z")
        {
            ans.erase(ans.begin()+i);
            ans.erase(ans.begin()+i-1);
            i = 0;
        }
        i++;
    }
    for(auto ch:ans)
        answer+=stoi(ch);
    return answer;
}