#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;


int N, K;


vector<int> q;
vector<int> rbt_pos;
//int rbt_pos[101] = {0};
int ans = 0;
void init()
{
    scanf("%d %d", &N, &K);
    for(int i=0;i<2*N;i++)
    {
        int tmp;
        scanf("%d", &tmp);
        q.push_back(tmp);
    }
    /*
    if(q[0] != 0)
    {
        q[0]--; // put 1st robot
                //rbt_pos[0] = 1;
        rbt_pos.push_back(0);
    }
    */
}

void con_move()
{
    int tmp = q[q.size()-1];
    q.pop_back();
    q.insert(q.begin(), tmp);
    for(int i=0;i<rbt_pos.size();i++)
    {
        rbt_pos[i]++;
    }
}

void get_robot()
{
        int idx = rbt_pos.size()-1;
        while(idx>=0)
        {
            if(rbt_pos[idx] >= N-1)
            {
                rbt_pos.erase(rbt_pos.begin()+idx);
                idx = rbt_pos.size()-1;
                continue;
            }
            idx--;
        }
}

void rbt_move()
{
   
    for(int i=rbt_pos.size()-1;i>=0;i--)
    {
        if(q[rbt_pos[i]+1] >= 1 && (find(rbt_pos.begin(), rbt_pos.end(),rbt_pos[i]+1) == rbt_pos.end()))
        {
            ++rbt_pos[i];
            --q[rbt_pos[i]];
        }
    }
}

void rbt_put()
{
    if(q[0] != 0)
    {
        q[0]--;
        rbt_pos.insert(rbt_pos.begin(),0);
    }
}

int check_durability()
{
    int sum = 0;
    for(int i=0;i<q.size();i++)
    {
        if(q[i] == 0)
            sum++;
    }
    return sum;
}

int main()
{
    init();

    while(1)
    {
        ans++;
        con_move();
        get_robot();
        rbt_move();
        get_robot();
        rbt_put();
        if(check_durability() >= K)
            break;
    }
    cout << ans;

}
