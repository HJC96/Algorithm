#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    int odd = 0;
    int even = 0;
    for(int i=0;i<num_list.size();i++)
    {
        if(num_list[i]%2 == 0)
            odd++;
        else even++;
    }
    answer.push_back(odd);
    answer.push_back(even);
    return answer;
}