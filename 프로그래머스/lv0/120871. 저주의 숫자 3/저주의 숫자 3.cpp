#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

bool find_3(int num)
{
    if((num%3 == 0) || (to_string(num).find("3") != string::npos))
        return true;
    return false;
}

int solution(int n) {
    int answer = 0;
    map<int,int> m;
    int num=1;
    for(int i=1;i<=100;i++)
    {
        if(find_3(num))
        {
            while(find_3(num)) num++;

            m[i] = num++;
            continue;
        }
        m[i] = num;
        num++;
    }
    answer = m[n];
    return answer;
}