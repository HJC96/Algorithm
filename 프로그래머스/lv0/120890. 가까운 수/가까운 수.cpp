#include <string>
#include <vector>
#include <algorithm>
#define abs(a) ((a) > (0) ? (a) : (-a))
#define min(a,b) ((a)>(b)?(b):(a))
using namespace std;

int solution(vector<int> array, int n) {
    int answer=0;
    sort(array.begin(), array.end());
    int value = 999;
    for(auto i:array)
    {
        if(abs((n-i)) < value)
            answer = i;
        value = abs((n-i));
    }
    return answer;
}