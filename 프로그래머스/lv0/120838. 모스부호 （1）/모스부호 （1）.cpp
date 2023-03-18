#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

string solution(string letter) {
    string answer = "";
    map<string, string> morse = { {".-","a"},{"-...","b"},{"-.-.","c"},{"-..","d"},{".","e"},{"..-.","f"},
{"--.","g"},{"....","h"},{"..","i"},{".---","j"},{"-.-","k"},{".-..","l"},
{"--","m"},{"-.","n"},{"---","o"},{".--.","p"},{"--.-","q"},{".-.","r"},
{"...","s"},{"-","t"},{"..-","u"},{"...-","v"},{".--","w"},{"-..-","x"},
{"-.--","y"},{"--..","z"}
};
    string tmp ="";
    int idx=0;
    for(auto mos:letter)
    {
        if(mos == ' ' || idx == letter.size()-1)
        {
            if(idx == letter.size()-1)
                tmp += mos;        
            answer += morse[tmp];
            tmp ="";
            idx++;
            continue;
        }
        tmp += mos;
        idx++;
    }
    return answer;
}