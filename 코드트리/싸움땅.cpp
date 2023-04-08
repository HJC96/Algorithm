#include <iostream>
#include <queue>
#pragma warning(disable:4996)


using namespace std;


int n, m, k;
//int map[21][21];

int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
priority_queue<int> q[442];
struct Person
{
   int x, y, d, s, idx, gun, pt;
}p[31];

void input()
{
   scanf("%d %d %d", &n, &m, &k);
   int gun_idx=1;
   for (int i = 1; i <= n; i++)
   {
      for (int j = 1; j <= n; j++)
      {
        int map;
         scanf("%d", &map);
         q[gun_idx++].push(map);
      }
   }

   for (int i = 1; i <= m; i++)
   {
       scanf("%d %d %d %d", &p[i].x, &p[i].y, &p[i].d, &p[i].s);
       p[i].idx = i;
       p[i].gun = 0;
       p[i].pt = 0;
   }
}


void action_loser(Person* tmp)
{
    bool move = true;
    // if(map[tmp->x][tmp->y] < tmp->gun)
    //     map[tmp->x][tmp->y] = tmp->gun;
    //if(q[(tmp->x-1)*n + tmp->y].top() < tmp->gun)
    q[(tmp->x-1)*n + tmp->y].push(tmp->gun);

    tmp->gun = 0;
    int cur_idx = tmp->idx;
    int dir = tmp->d;
    bool stop = false;
    while(move)
    {
        int cur_x = tmp->x + dx[dir];
        int cur_y = tmp->y + dy[dir];
        for(int i=1;i<=m;i++)
        {
            if(i == cur_idx)
                continue;
            if(p[i].x == cur_x && p[i].y == cur_y)
            {
                dir = (dir+1)%4;
                stop = true;
                break;
            }
        }
        if(stop)
        {
            stop = false;
            continue;
        }
        //cur_x = tmp->x + dx[dir];
        //cur_y = tmp->y + dy[dir];
        if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y > n)
        {
            // turn right 90'
            dir = (dir+1)%4;    
        }
        else
        {
            move = false;
        }
    }
        
    tmp->x += dx[dir];
    tmp->y += dy[dir];
    tmp->d = dir;
    if(q[(tmp->x-1)*n + tmp->y].empty() != 1)
    {
        tmp->gun = q[(tmp->x-1)*n + tmp->y].top();
        q[(tmp->x-1)*n + tmp->y].pop();
    }

}

void action_winner(Person* tmp)
{
    int cur_x = tmp->x;
    int cur_y = tmp->y;
    // already have gun
    //if(map[cur_x][cur_y] != 0 && tmp->gun != 0)
    if(q[(cur_x-1)*n + cur_y].empty() != 1 && tmp->gun != 0)
    {
        // if player have gun ,then compare gun 
        //if(tmp->gun < map[cur_x][cur_y])
        if(tmp->gun < q[(cur_x-1)*n  + cur_y].top())
        {
            int swap = tmp->gun;
            tmp->gun = q[(cur_x-1)*n  + cur_y].top();
            q[(cur_x-1)*n  + cur_y].pop();
            q[(cur_x-1)*n  + cur_y].push(swap);
            // int swap = tmp->gun;
            // tmp->gun = map[cur_x][cur_y];
            // map[cur_x][cur_y] = swap;
        }
    }
    //else if(map[cur_x][cur_y] != 0 && tmp->gun == 0)
    else if(q[(cur_x-1)*n  + cur_y].empty() != 1 && tmp->gun == 0)
    {
        // get gun
        //tmp->gun = map[cur_x][cur_y];
        tmp->gun = q[(cur_x-1)*n  + cur_y].top();
        q[(cur_x-1)*n  + cur_y].pop();
    }
    return ; 

}

void move_player(Person *tmp)
{
    int dir = tmp->d;
    int cur_x = tmp->x + dx[dir];
    int cur_y = tmp->y + dy[dir];
    
    if(cur_x < 1 || cur_y < 1 || cur_x > n || cur_y > n )
    {
        dir = (tmp->d+2)%4;          
    }
    tmp->x += dx[dir];
    tmp->y += dy[dir];
    tmp->d = dir;
}


bool check_player(Person* tmp)
{
    int cur_x = tmp->x;
    int cur_y = tmp->y;
    int cur_idx = tmp->idx;
    for(int i=1;i<=m;i++)
    {
        if(i == cur_idx)
            continue;
        if(p[i].x == cur_x && p[i].y == cur_y)
        {
            return true;
        }
    }
   return false;
}

void check_gun(Person* tmp)
{
   int cur_x = tmp->x;
   int cur_y = tmp->y;
    
    // 2-1 already have gun
    //if(map[cur_x][cur_y] != 0 && tmp->gun != 0)
    if(q[(cur_x-1)*n  + cur_y].empty() != 1 && tmp->gun != 0)
    {
        // if player have gun ,then compare gun 
        //if(tmp->gun < map[cur_x][cur_y])
        if(tmp->gun < q[(cur_x-1)*n  + cur_y].top())
        {
            //  int swap = tmp->gun;
            //  tmp->gun = map[cur_x][cur_y];
            //  map[cur_x][cur_y] = swap;
            int swap = tmp->gun;
            tmp->gun = q[(cur_x-1)*n  + cur_y].top();
            q[(cur_x-1)*n  + cur_y].pop();
            q[(cur_x-1)*n  + cur_y].push(swap);
        }
    }
    // 2-1 no gun 
    //else if(map[cur_x][cur_y] != 0 && tmp->gun == 0)
    else if(q[(cur_x-1)*n  + cur_y].empty() != 1 && tmp->gun == 0)
    {
        // get gun
        tmp->gun = q[(cur_x-1)*n  + cur_y].top();
        q[(cur_x-1)*n  + cur_y].pop();
        //tmp->gun = map[cur_x][cur_y];
        
    }
    return ;
   
}

void fight(Person* tmp)
{
    // find person
    int cur_x = tmp->x;
    int cur_y = tmp->y;
    int cur_idx = tmp->idx;
    int enemy_idx = 0;
    for(int i=1;i<=m;i++)
    {
        if(i == cur_idx)
            continue;
        if(p[i].x == cur_x && p[i].y == cur_y)
        {
            enemy_idx = p[i].idx;
        }
    }
    
    // calculate strength
    int Player_pw = tmp->s + tmp->gun;
    int Enemy_pw  = p[enemy_idx].s + p[enemy_idx].gun;

    if(Player_pw == Enemy_pw)
    {
        // player win
        if(tmp->s > p[enemy_idx].s)
        {
            //tmp->pt += tmp->s - p[enemy_idx].s;
            action_loser(&p[enemy_idx]);
            action_winner(tmp);
        }
        // enemy win
        else if(tmp->s < p[enemy_idx].s)
        {
            //p[enemy_idx].pt += p[enemy_idx].s - tmp->s;
            action_loser(tmp);
            action_winner(&p[enemy_idx]);
        }
    }
    else if (Player_pw > Enemy_pw)
    {
        tmp->pt += Player_pw - Enemy_pw;
        action_loser(&p[enemy_idx]);
        action_winner(tmp);
    }
    else if (Player_pw < Enemy_pw)
    {
        p[enemy_idx].pt += Enemy_pw - Player_pw;
        action_loser(tmp);
        action_winner(&p[enemy_idx]);
    }
}

void check(Person* p)
{
   if (check_player(p) == true)
   {
      fight(p);
   }
   else    check_gun(p);
}


int main()
{
   input();
   for(int i=1;i<=k;i++)
   {
    for (int j = 1; j <= m; j++)
    {
        move_player(&p[j]);
        check(&p[j]);   
    }
   }
   for(int i=1;i<=m;i++)
   {
        cout << p[i].pt << " ";
   }


    return 0;
}
