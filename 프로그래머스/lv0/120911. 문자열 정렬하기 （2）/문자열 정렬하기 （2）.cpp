#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

char to_lower(char ch)
{
    if(int(ch) < 97)
    {
        int idx = ch - 'A';
        ch = 'a' + idx;
    }
    return ch;
}


string solution(string my_string) {
    string answer = "";
    for(int i=0;i<my_string.size();i++)
       answer += to_lower(my_string[i]);
    sort(answer.begin(),answer.end());
    return answer;
}