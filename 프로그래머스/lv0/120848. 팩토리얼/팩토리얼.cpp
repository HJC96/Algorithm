#include <string>
#include <vector>

using namespace std;

int fac(int n)
{
    if(n == 1 || n == 0)  return 1;
    else return n * fac(n-1);
}

int solution(int n) {
    int idx = n;
    int answer = 1;
    while(idx >= fac(answer)) answer++;
        
    return answer-1;
}