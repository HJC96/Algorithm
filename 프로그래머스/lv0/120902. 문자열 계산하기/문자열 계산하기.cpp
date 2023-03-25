#include <string>
#include <vector>
#include <iostream>
#include <queue>
using namespace std;

queue<int> q1;
queue<char> q2;
int solution(string my_string) {
    int answer = 0;
    my_string+="Q";
    
    int i=0;
    for(int idx=0;idx<my_string.size();idx++)
    {
        if(my_string[idx] != '+' && my_string[idx] != '-' && my_string[idx] != 'Q')
            continue;    
        else
        {
            q1.push(stoi(my_string.substr(i,idx)));
            q2.push(my_string[idx]);
            i=idx+1;
        }
    }
    answer += q1.front();
    q1.pop();
    while(q1.size()>0)
    {
        if(q2.front() == '+')
        {
            answer += q1.front();
            q1.pop();
            q2.pop();
        }    
        else if(q2.front() == '-')
        {
            answer -= q1.front();
            q1.pop();
            q2.pop();
        }
    }
    
    
    return answer;
}