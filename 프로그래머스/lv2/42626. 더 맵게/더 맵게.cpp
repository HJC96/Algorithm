#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int> q;
    for(auto ele:scoville)
        q.push(-ele);
    while(q.top() > -K && q.size()>1)
    {
         int fron = q.top();
         q.pop();
         int secon = q.top();
         q.pop();
         q.push(fron + secon*2);
         answer+=1;   
    }
    if(q.top() > -K) 
        answer = -1;
    return answer;
}