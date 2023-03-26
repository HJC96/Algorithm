#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;
int N;
vector<int> v;
void init()
{
    scanf("%d", &N);
    int tmp;
    for(int i=0;i<N;i++)
    {
        scanf("%d",&tmp);
        v.push_back(tmp);
    }
}

int solve1(vector<int> v)
{
    double ans=0;
    int len = v.size();
    for(int i=0;i<len;i++)
        ans+=v[i];
    ans /= len;
    ans = round(ans);
    return  int(ans);
    //return int(ans/v.size());
}

int solve2(vector<int> v)
{
    sort(v.begin(),v.end());
    return v[v.size()/2];
}
int solve3(vector<int> v)
{
    int ans[8001] = {0,};
    int answer = 0;
    int m = -1; 
    vector<int> idx;
    for(int i=0;i<v.size();i++)
    {
        ans[v[i]+4000]++;
        if(ans[v[i]+4000] >= m)
        {
            if(ans[v[i]+4000] > m)
            {
                while(idx.size()>0)
                    idx.erase(idx.begin());
            }
            m=ans[v[i]+4000];
            idx.push_back(v[i]);
        }
    }
    sort(idx.begin(),idx.end());
    if(idx.size()>1)
        answer = idx[1];
    else answer = idx[0];
    return answer;
}
int solve4(vector<int> v)
{
    sort(v.begin(),v.end());
    return v[v.size()-1] - v[0];
}
int main()
{
    init();
    vector<int> cal = v;
    cout << solve1(cal) << endl;
    cout << solve2(cal) << endl;
    cout << solve3(cal) << endl;
    cout << solve4(cal);
}
