#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    int length = s.size();       
    
    int idx = 0;
    for(int i=0; i<length ;i++)
    {
        if(s[i] == ' ')
        {
            idx = 0;
            continue;
        }
        if(idx % 2 == 0)
            s[i] = toupper(s[i]);
        else
            s[i] = tolower(s[i]);
        idx++;
    }
    return s;
    
}