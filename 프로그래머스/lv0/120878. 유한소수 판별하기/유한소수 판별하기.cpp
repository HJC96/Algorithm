#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 1;
    int idx = 2;
    while(idx <= a)
    {
        if( (a % idx == 0) && (b % idx == 0))
        {
            a/=idx;
            b/=idx;
            idx=1;
        }
        idx++;
    }
    while(b%2 == 0) b/=2;
    while(b%5 == 0) b/=5;
    for(int i=3;i<=b;i++)
    {
        if(i == 5)
            continue;
        else if(b%(i)== 0)
        {
            answer = 2;
            break;
        }
    }
    
    return answer;
}