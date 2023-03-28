#include <string>
#include <vector>
#define max(a,b) ((a)>(b)?(a):(b))
using namespace std;

int solution(vector<int> numbers) {
    int answer = -99999999999;
    for(int i=0;i<numbers.size();i++)
    {
        for(int j=i+1;j<numbers.size();j++)
        {
            answer = max(answer,numbers[i]*numbers[j]);
        }
    }
        
    return answer;
}