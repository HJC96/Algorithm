#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

#define min(a,b) ((a) > (b) ? (b) : (a))
using namespace std;

int solution(string name) 
{
    int answer = 0;
    int L1 = 0;
    int L2 = 0;
        int n = name.length();

    int move = name.size() - 1;
    for(int i=0; i<name.size();i++)
    {
        answer += min(name[i] - 'A','Z' - name[i] +1);

        
       int ind = i + 1;
        while (ind < n && name[ind] == 'A') ind++;

        move = min(move, i + n - ind + min(i, n - ind));
    }

    return answer + move;
}

//"JAN" = 23

int main()
{
   cout << solution("JEROEN");
}