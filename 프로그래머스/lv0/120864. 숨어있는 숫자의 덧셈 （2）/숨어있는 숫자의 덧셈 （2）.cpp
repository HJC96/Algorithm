#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string my_string) {
    int answer = 0;
    vector<int> v;
    int idx=0;
    int idx1=0;
    while(1)
    {
        while((int(my_string[idx]) <= 57 && int(my_string[idx]) >= 48) == 0 && idx < my_string.size()) idx++;
        idx1 = idx;
        while((int(my_string[idx1]) <= 57 && int(my_string[idx1]) >= 48) == 1 && idx1 < my_string.size()) idx1++;
        if(idx < my_string.size())
            answer += stoi(my_string.substr(idx,idx1-idx));
        else
            break;
        idx=idx1;
    }
    return answer;
}