#include <string>
#include <vector>
#include <iostream>
#define min(a,b) ((a)<(b)?(b):(a))
using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    vector<int> answer;
    
    int mi = denom1 * denom2;
    int a = mi / denom1 * numer1;
    int b = mi / denom2 * numer2;

    int numer = a+b;
    int deno  = mi;
    int i=1;
    while(i<min(a,b) + 1)
    {
        if(numer%i == 0 && deno%i == 0)
        {
            numer /= i;
            deno  /= i;
            i = 2;
            continue;
        }
        i++;
    }
    answer.push_back(numer);
    answer.push_back(deno);
    return answer;
}