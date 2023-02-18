#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

#define min(a,b) ((a) > (b) ? (b) : (a))
using namespace std;

int solution(string name) 
{
    int answer = 0;
    int L2 = 0;
    int move = name.size() - 1;
    int length = name.size();

    for(int L1=0; L1<name.size();L1++)
    {   
        answer += min(name[L1] - 'A','Z' - name[L1] +1);        
        
        int L2_idx = L1+1;
        while(L2_idx < length)
        {
            if(name[L2_idx] == 'A')
                L2_idx++;
            else
                break;
        }
        L2 = length - 1 - L2_idx + 1;
        move = min(move, L1 + L2 + min(L1, L2));         
    }
    return answer + move;
}


//"JAN" = 23

int main()
{
   cout << solution("AAAAABBAAAAAAABAAA");
}
// 012345678901234567
// AAAAABBAAAAAAABAAA

