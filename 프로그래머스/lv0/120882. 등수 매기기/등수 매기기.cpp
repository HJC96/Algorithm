#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>
using namespace std;

bool comp(int a, int b)
{
    if(a>b) return true;
    else    return false;
}

vector<int> solution(vector<vector<int>> score) {
    vector<int> answer;
    vector<int> temp;
    map<int,int> m;
    for(int i=0; i<score.size();i++)
    {
        int tmp = score[i][0] + score[i][1]; 
        temp.push_back(tmp);        
    }
    vector<int> mp = temp;
    sort(mp.begin(),mp.end(),comp);
    int i=1;
    for(auto elem:mp)
    {
        m.insert({elem,i++});
    }
    for(int i=0;i<temp.size();i++)
    {
        answer.push_back(m[temp[i]]);
    }
    return answer;
}

/*
    1. 
    hash 
    150
    150
    80
    190
    190
    200
    40



*/