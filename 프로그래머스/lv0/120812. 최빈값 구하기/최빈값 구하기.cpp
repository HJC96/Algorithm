#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#define max(a,b) ((a)>(b)?(a):(b))
using namespace std;

int solution(vector<int> array)
{
    int answer = 0;
    int idx;
    int ary[1001] = {0};
    bool dup = false;
    for(int i=0;i<array.size();i++)
    {
        ary[array[i]]++;  
    }
    int max_cnt = 0;
    for(int i=0;i<1001;i++)
    {

        if(ary[i] == max_cnt)
            dup = true;
        else if(ary[i]>max_cnt)
        {
            dup = false;
            idx =i;
        }
        max_cnt =max(max_cnt, ary[i]);
    }
    
    if(dup)
        idx =-1;
    return idx;
}