#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int i, int j, int k) {
    int answer = 0;
    vector<string> tmp;
    string find_num = to_string(k);
    for(int idx=i;idx<=j;idx++)
    {
        string st = to_string(idx);
        while(st.find(find_num) != string::npos)
        {
            answer++;
            st.erase(0,st.find(find_num)+1);
        }
            
    
    }
        
        
    
   
    return answer;
}