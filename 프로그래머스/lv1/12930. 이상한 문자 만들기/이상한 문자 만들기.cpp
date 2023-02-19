#include <string>
#include <vector>
#include <iostream>
using namespace std;
// 투포인터	" TrY HeLlO WoRlD "
string solution(string s) {
    int idx = 0;
    for(int i=0; i<s.size();i++)
    {
        if(s[i] == ' ')
        {
            idx=0;
            continue;
        }
        if(idx % 2 == 0) s[i] = toupper(s[i]);
        else             s[i] = tolower(s[i]);
        idx++;
    }
    return s;
    
}