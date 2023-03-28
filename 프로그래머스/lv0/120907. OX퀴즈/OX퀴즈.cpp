#include <string>
#include <vector>
#include <iostream>

using namespace std;
vector<string> split(string input, string delimiter) { 
    vector<string> ret;
    long long pos = 0;
    string token = "";
    while ((pos = input.find(delimiter)) != string::npos)
    {
        token = input.substr(0, pos);
        ret.push_back(token);
        input.erase(0, pos + delimiter.length());
    } 
    ret.push_back(input); return ret;
}

vector<string> solution(vector<string> quiz) {
    vector<string> answer;
    for(int i=0;i<quiz.size();i++)
    {
        int idx = 0;
        int cal = 0;
        string st = "";
        
        st = quiz[i];
        
        
        int id=0;
        int right = 0;
        int left = 0;
        int x = 0;
        while(id<st.size())
        {
            if(st[id] == '=')
            {
                right = stoi(st.substr(id+1,st.size()+1));
                st.erase(id, st.size()+1);
                x = id;
                break;
            }
            id++;
        }
        vector<string> a = split(st," ");
        left = stoi(a[0]);
        for(int i=1;i<a.size()-1;i+=2)
        {
            if(a[i] == "+")
                left += stoi(a[i+1]);
            else
                left -= stoi(a[i+1]);
        }
        
        // while(n<st.size())
        // {
        //      if(st[n] == ' ')
        //      {
        //          if(n%2 == 0)
        //          {
        //             str.push_back(st.substr(0,n)) ;
        //          }
        //          n = 0;
        //          continue;
        //      }
        //     n++;
        // }

        if(right == left)   answer.push_back("O");
        else   answer.push_back("X");
    }
    return answer;
}