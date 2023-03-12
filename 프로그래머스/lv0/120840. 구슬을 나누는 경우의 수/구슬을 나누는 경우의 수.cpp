#include <string>
#include <vector>

#define min(a,b) ((a)>(b)?(b):(a))
#define max(a,b) ((a)>(b)?(a):(b))

using namespace std;

int solution(int balls, int share) {
    unsigned long long answer = 1;
    int j = 1;
    for(int i=min(balls,share)+1;i<=max(balls,share);i++)
    {
        if(j > balls-share) answer = answer*i;
        else
        {
            answer = answer*i/j;
            j++;
        }
    }
    

    return answer;
}