#include <string>
#include <vector>
#include <algorithm>
#include <iostream>


#define abs(a) ((a)>(0)?(a):(-a))
using namespace std;


bool comp(const pair<int,int>& a, const pair<int,int>& b)
{
    if(a.second == b.second) return a.first>b.first;
    return a.second < b.second;
}


vector<int> solution(vector<int> numlist, int n) {
    vector<int> answer;
    vector<pair<int,int>> v;
    for(int i=0;i<numlist.size();i++)    v.push_back({numlist[i], abs((numlist[i] -n))});
    sort(v.begin(),v.end(),comp);
    for(auto elem:v)    answer.push_back(elem.first);
    
    return answer;
}