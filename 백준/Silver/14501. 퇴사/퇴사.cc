#include <iostream>
#include <vector>
#include <algorithm>


#define pr pair<int,int>
#define max(a,b) ((a)>(b)?(a):(b))

using namespace std;

vector<pr> calender;
int answer =0;
int tmp = 0;
int sec_tmp = 0;
    int sq_tmp = 0;
int solve(int day, int pay , int today)
{
    /* present */
    if(today+day>calender.size())    return tmp;
    tmp += pay;
    int save = tmp;
    today += day;
    day = calender[today].first;
    for(int i=today;i<calender.size();i++)
    {
        if(i <calender.size()){
            sec_tmp = solve(calender[i].first, calender[i].second, i);
            sq_tmp = max(sec_tmp,sq_tmp);
        }
        tmp = save;
    }
    return tmp;
}



int main()
{

    int N, T, P;
    scanf("%d", &N);

    for(int i=0;i<N;i++)
    {
        scanf("%d %d",&T, &P);
        calender.push_back(make_pair(T, P));
    }

    int ans = 0;
    for(int i=0;i<calender.size();i++)
    {
        ans = solve(calender[i].first, calender[i].second, i);
        answer = max(answer, ans);
        tmp = 0;
    }
    cout << max(answer,sq_tmp);

    return 0;
}