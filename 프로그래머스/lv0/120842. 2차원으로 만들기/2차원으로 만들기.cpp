#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<int> num_list, int n) {
    vector<vector<int>> answer;
    vector<int> tmp;
    tmp.push_back(num_list[0]);
    for(int i=1;i<num_list.size();i++)
    {
        if(i % n == 0 || i == num_list.size()-1)
        {
            if(i == num_list.size()-1)
                tmp.push_back(num_list[i]);
            answer.push_back(tmp);
            tmp.clear();
        }
        tmp.push_back(num_list[i]);
    }
    return answer;
}