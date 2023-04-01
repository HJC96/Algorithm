#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<string> split(string In, string del)
{
    string token;
    vector<string> res;
    long long pos;
    while((pos = In.find(del)) != string::npos)
    {
        token = In.substr(0,pos);
        res.push_back(token);
        In.erase(0, pos+del.size());
    }
    res.push_back(In);
    return res;

}
string solution(string polynomial) {
    string answer = "";
    vector<string> res;
    int x_num =0;
    int num = 0;
    res = split(polynomial, " ");
    long long idx=0;
    for(auto ch:res)
    {
        if(ch == "+")
            continue;
        if((idx=ch.find("x")) != string::npos)
        {
            if(ch.size()>1)
                x_num += stoi(ch.substr(0, idx));       
            else 
                x_num++;
        }
        else
            num += stoi(ch);
    }
    if(num)
    {
        if(x_num == 1)
            answer = "x + " + to_string(num) ;  
        else if (x_num == 0)
            answer = to_string(num) ;  
        else
            answer = to_string(x_num) + "x" + " + " + to_string(num) ;
    }
    else
    {
        if(x_num == 1)
            answer += "x";
        else
            answer = to_string(x_num) + "x" ;
    
    }    
    return answer;
}