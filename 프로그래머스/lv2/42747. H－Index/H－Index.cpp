#include <string>
#include <vector>
#include <algorithm>
#define max(a,b) ((a)>(b)?(a):(b))

bool comp(int a, int b)
{
    if(a > b) return true;
    else return false;
}
using namespace std;
int solution(vector<int> citations) {
    int length = citations.size();
    sort(citations.begin(), citations.end(), comp);
    
    int idx = 0;
    int answer =0;
    while(idx <citations[idx] && idx <citations.size())
	{
		answer = min(citations[idx], idx + 1);
		idx++;
	}
    
    return answer;
}

