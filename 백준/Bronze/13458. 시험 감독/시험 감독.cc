#include <iostream>
#include <vector>


using namespace std;
int main()
{
    int N;
    long answer = 0;
    vector<int> tmp;
    
    scanf("%d", &N);
    for(int i=0;i<N;i++)
    {
        int A;
        scanf("%d",&A);
        tmp.push_back(A);
    }
    int B, C;
    scanf("%d %d",&B,&C);
    
    int idx = 0;
    while(idx < tmp.size())
    {
        tmp[idx] -= B;
        if(tmp[idx] < 0)
            tmp[idx] = 0;
        answer++;
        idx++;
    }

    idx=0;
    while(idx<tmp.size())
    {
        int div = tmp[idx]/C;
        if(tmp[idx]%C == 0)
        {
            answer=answer + div;
            idx++;
        }
        else
        {
            answer=answer + div + 1;
            idx++;
        }
    }

    cout << answer;
    return 0;

}