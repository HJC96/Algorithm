#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array) {
    int answer = 0;
    for(int i=0;i<array.size();i++)
    {
        for(auto ch:to_string(array[i]))
        {
            if(ch == '7')
                answer +=1;
        }
    }
    
    return answer;
}