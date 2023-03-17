#include <iostream>
#include <vector>
#include <algorithm>
#define min(a,b) ((a)>(b)?(b):(a))
#define abs(a) ((a)>(0)?(a):(-a))
using namespace std;

int** arr;

void solve(int num);


int T;
int ans = 101;
int pick[20] = {0};
int start[10];
int link[10];

void init()
{

    scanf("%d", &T);
    arr = new int*[T];

    for(int i=0;i<T;i++)
    {
        arr[i] = new int[T];
    }
    for(int i=0;i<T;i++)
        for(int j=0;j<T;j++)
            scanf("%d", &arr[i][j]);
}


void dfs(int cur, int pick_count)
{
    if(pick_count == T/2)
    {
        int temp_start = 0;
        int temp_link  = 0;

        int temp_size1 = 0;
        int temp_size2 = 0;
        
        for(int i=0;i<T;i++)
        {
            if(pick[i] == 1)    start[temp_size1++] = i+1;
            else                link[temp_size2++]  = i+1; 
        }

        for(int i=0;i<pick_count;i++)
        {
            for(int j=i+1;j<pick_count;j++)
            {
                temp_start = temp_start + arr[start[i]-1][start[j]-1] + arr[start[j]-1][start[i]-1];
                temp_link  = temp_link  + arr[link[i]-1][link[j]-1] + arr[link[j]-1][link[i]-1];
            }
        }
        int tmp = temp_start - temp_link;
        ans = min(ans, abs(tmp));
        return ;
    }

    for(int i=cur;i<T;i++)
    {
        pick[i] = 1;
        dfs(i+1, pick_count+1);
        pick[i] = 0;
    }

}

int main()
{
    init();
    dfs(0,0);
    printf("%d",ans);

}
