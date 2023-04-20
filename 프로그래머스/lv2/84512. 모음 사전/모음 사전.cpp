#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

char word[5] = {'A', 'E', 'I', 'O', 'U'};
vector<string> v;
void dfs(int num, string st){
    string tmp = st;
    if( num == 6)
        return;
    v.push_back(tmp);
    for(int i=0;i<5;i++){
        dfs(num+1,tmp+word[i]);
    }
}


int solution(string word) {
    
    dfs(0,"");
    int answer = find(v.begin(),v.end(),word) - v.begin();
    return answer;
}