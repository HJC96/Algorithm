#include <string>
#include <vector>

using namespace std;

int solution(vector<int> common) {
    long answer = 0;
    int r;
    if(common[0] != 0)
        r = common[1]/common[0];
    else r = 1;
    double d = common[1]-common[0];
    if(d == common[2]-common[1])
        answer = common[common.size()-1] + d;
    else
        answer = common[common.size()-1]*r;
    return answer;
}