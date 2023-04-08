#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int n;
int map[30][30];
int group[30][30];
int visited[30][30] = {0,};
int dx[4] = {-1,0,1,0}; int dy[4] = {0,1,0,-1}; 
int answer = 0; int group_cnt = 1;
int group_hash[30]={0,}; // hash table
int group_count_of_num[30]={0,};

int near_num[30][30] = {0,};

void input()
{
    scanf("%d", &n);
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            scanf("%d", &map[i][j]);
        }
    }
}

void make_group(int x, int y)
{
    // set num 
    int num = map[x][y];

    // save value count
    int save = 1;

    // set group
    group[x][y] = group_cnt;
    // set visited not to repeat
    visited[x][y] = 1;
    queue<int> q;
    q.push(x);    q.push(y);
    while(!q.empty())
    {
        int nx = q.front(); q.pop();
        int ny = q.front(); q.pop();
        
        for(int k=0;k<4;k++)
        {
            int cur_x = nx + dx[k];
            int cur_y = ny + dy[k];

            if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y > n || visited[cur_x][cur_y] == 1 || map[cur_x][cur_y] != num)
                continue;
            /*
            if(map[cur_x][cur_y] != num)
            {
                //near_num[num][map[cur_x][cur_y]]++; 뒤에껀 해쉬값으로... 해야할듯
                near_num[num][group[cur_x][cur_y]]++;
            }
            */
            visited[cur_x][cur_y] = 1;
            group[cur_x][cur_y] = group_cnt;
            save++;
            q.push(cur_x); q.push(cur_y);
        }
    }
    //save group_count_num to calculate art_score
    group_count_of_num[group_cnt] = save;
    group_hash[group_cnt] = num;
    group_cnt++;
}

// eq
// (그룹 a에 속한 칸의 수 + 그룹 b에 속한 칸의 수 ) x 그룹 a를 이루고 있는 숫자 값 x 
//  그룹 b를 이루고 있는 숫자 값 x 그룹 a와 그룹 b가 서로 맞닿아 있는 변의 수

/*
    key -> 

    1. 그룹 만드는건 BFS/DFS로 할 수 있음.
    2. 아... 조합을 해야하는 구나.
    
    초기 예술점수 구하기
    1. 12 13 14 23 24 34 이렇게 조합을 만든후에 조화로움 값을 계산
    2. 조화로움의 값이 0 보다 큰걸 찾고 전부 더한다
    3. 이를 초기 예술 점수라 한다.

    조화로움의 값 계산하기
    1. a 속한 칸의 개수
    2. b 속한 칸의 개수
    3. 맞닿아 있는 변
    4. a의 숫자
    5. b의 숫자

    여기서 고려해야할 사항이
    그룹 4같은 경우는 실제로 4로 세팅할 수 있지만, 그 칸의 숫자는 1로 되어야함... 
    이 케이스를 어떻게 고려할 수 있을까?
    그냥 변수에 저장해놓고 그걸 보면 되지 않을까? 해쉬 테이블처럼

    맞닿은 것도 배열 하나 만들어서 체크해야할 것 같은데... 어떻게?
*/
int calculate(int g1, int g2)
{
    //int G1 = group_hash[g1];
    int res = (group_count_of_num[g1] + group_count_of_num[g2]) * group_hash[g1] * group_hash[g2] * near_num[g1][g2]; // *맞닿은 변
    // how to check 맞닿은 변?
    return res;
}

void init()
{
    int group_cnt = 1;
    for(int i=1;i<=n;i++)
    {
        group_count_of_num[i] = 0;
        group_hash[i] =0;

        for(int j=1;j<=n;j++)
        {
            visited[i][j] = 0;
            group[i][j] = 0;
            near_num[i][j] = 0;
        }
    }
}



void make_near(int nx,int ny)
{
    int check = group[nx][ny];
    for(int k=0;k<4;k++)
    {
        int cur_x = nx + dx[k];
        int cur_y = ny + dy[k];
        if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y > n )
            continue;
        if(check != group[cur_x][cur_y])
        {
            near_num[check][group[cur_x][cur_y]]++;
        }
    }

}

void rotate_2(int x, int y, int length)
{
    int tmp[length][length] ={0,};

    for(int j=1;j<=(length-1);j++)
    {
        for(int i=1;i<=(length-1);i++)
        {
            tmp[i][length-j] = map[x+j-1][y+i-1];
        }
    }

    for(int i=1;i<=(length-1);i++)
    {
        for(int j=1;j<=(length-1);j++)
        {
            map[i-1+x][j-1+y]=tmp[i][j];
        }
    }

}

void rotate()
{
    int middle = int(n/2) + 1;
    
    //cross rotate
    for(int i=1;i<=middle-1;i++)
    {
        int tmp = map[i][middle];
        map[i][middle] = map[middle][n+1-i];
        map[middle][n+1-i] = map[n+1-i][middle];
        map[n+1-i][middle] = map[middle][i];
        map[middle][i] = tmp;        
    }
    rotate_2(1,1, middle);
    rotate_2(1,middle+1, middle);
    rotate_2(middle+1,1, middle);
    rotate_2(middle+1,middle+1, middle);
}
int main() 
{
    input();
    for(int i=1;i<=4;i++)
    {
        //init
        if(i>=2)
            init();
        // make group
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(!visited[i][j])
                    make_group(i,j);
            }
        }
        // check near_by
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                make_near(i,j);
            }
        }

        for(int i=1;i<group_cnt;i++)
        {
            for(int j=1+i;j<=group_cnt;j++)
            {
                int art_score = calculate(i,j);
                if(art_score == 0)
                    continue;
                else
                    answer += art_score;
            }
        }
        if(i==4)
            break;
        rotate();
        // cout << map[1][1];
        // break;

    }
    // for(int i=1;i<=n;i++)
    // {
    //     for(int j=1;j<=n;j++)
    //     {
    //         cout << map[i][j];
    //     }
    //     cout << endl;
    // }
    cout << answer;
    return 0;
}



