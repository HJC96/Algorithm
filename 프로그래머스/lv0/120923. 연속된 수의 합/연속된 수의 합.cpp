#include <string>
#include <vector>

using namespace std;

int sum_(vector<int> num)
{
    int ans = 0;
    for(int i=0;i<num.size();i++)
        ans += num[i];
    return ans;
}

vector<int> solution(int num, int total) {
    vector<int> answer;
    for(int i=1;i<=num;i++)
        answer.push_back(i);
    while(sum_(answer) < total)
    {
        answer.erase(answer.begin());
        answer.push_back(++num);
    }
    if(sum_(answer) == total)
        return answer;
    else
    {
        while(sum_(answer) != total)
        {
            answer.pop_back();
            answer.insert(answer.begin(),answer[0]-1);
        }
        return answer;
    }
}