#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int visited[11] = {0,};
int answer = 2;

void Combi(string st, vector<string> dic, vector<string> spell)
{
    string temp_str = "";
    temp_str += st;
    
    for(int i=0;i<spell.size();i++)
    {
        if(visited[i] == 1)
            continue;
        visited[i] = 1;
        Combi(temp_str+spell[i],dic,spell);
        visited[i] = 0;   
    }
    if(find(dic.begin(),dic.end(),temp_str) != dic.end())
    {
        if(temp_str.size() == spell.size())
            answer = 1;
    }
}


int solution(vector<string> spell, vector<string> dic) {
    for(int i=0;i<spell.size();i++)
    {
        visited[i] = 1;
        Combi(spell[i],dic, spell);
        visited[i] = 0;
    }
    return answer;
}