#include <iostream>
#include <vector>
#include <algorithm>
#define max(a,b) ((a)>(b)?(a):(b))
#define min(a,b) ((a)<(b)?(a):(b))


using namespace std;

vector<int> arr;
vector<char> oper;

int ans_max = -2000000000;
int ans_min =  2000000000; // will be updated


char operation[4] = {'+','-','*','/'};
void solve(char ch, vector<int> tmp, vector<char> temp_oper);
int main()
{
    int T;
    scanf("%d", &T);
    for(int i=0;i<T;i++)
    {
        int tmp;
        scanf("%d",&tmp);
        arr.push_back(tmp);
    }

    for(int i=0;i<4;i++)
    {
        int tmp;
        scanf("%d",&tmp);
        for(int j=0;j<tmp;j++)
            oper.push_back(operation[i]);
    }

    vector<int> tmp;
    vector<char> tmp_oper;
    for(auto ch:oper)
    {   
        vector<int> tmp = arr;
        vector<char> tmp_oper = oper;
        solve(ch, tmp, tmp_oper);

    }
    cout << ans_max<<endl;
    cout << ans_min<<endl;
    return 0;
}

void solve(char ch, vector<int> tmp, vector<char> temp_oper)
{
    temp_oper.erase(find(temp_oper.begin(),temp_oper.end(),ch));
    if(ch == '+')
    {
        int cal = tmp[0] + tmp[1];
        tmp.erase(tmp.begin(), tmp.begin()+2);
        tmp.insert(tmp.begin(), cal);
    }
    else if(ch == '-')
    {
        int cal = tmp[0] - tmp[1];
        tmp.erase(tmp.begin(), tmp.begin()+2);
        tmp.insert(tmp.begin(), cal);
    }
    else if(ch == '*')
    {
        int cal = tmp[0] * tmp[1];
        tmp.erase(tmp.begin(), tmp.begin()+2);
        tmp.insert(tmp.begin(), cal);

    }
    else if(ch == '/')
    {
        int cal = tmp[0] / tmp[1];
        tmp.erase(tmp.begin(), tmp.begin()+2);
        tmp.insert(tmp.begin(), cal);
    }
    for(auto ch:temp_oper)
    {
        solve(ch, tmp, temp_oper);
    }
    if(temp_oper.size() == 0)
    {
        ans_max = max(ans_max, tmp[0]);
        ans_min = min(ans_min, tmp[0]);
    }

}
