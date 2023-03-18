#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

bool comp(int a, int b)
{
    if(a>b) return true;
    else    return false;
}
vector<int> solution(vector<int> emergency) {
    vector<int> answer;
    
    /* 1. copy */
    vector<int> tmp = emergency;
    
    /* 2. sort */
    sort(tmp.begin(), tmp.end(), comp);
    
    /* 3. mapping */
    map<int, int> m;
    for(int i=0;i<tmp.size();i++)
        m[tmp[i]] = i+1;
    
    /* 4. make answer */
    for(int i=0;i<tmp.size();i++)
        answer.push_back(m[emergency[i]]); 
    
    return answer;
}