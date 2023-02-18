#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

#define min(a,b) ((a) > (b) ? (b) : (a))
using namespace std;

int solution(string name) {
    int answer = 0;
    int min_move = 999;
    vector<int> task_for;  // 0: remaining task 
    vector<int> not_A_idx_for; 
    vector<int> not_A_idx_back;
    int idx = 0;
    for(auto ch:name)
    {
        if(ch == 'A') task_for.push_back(1);
        else
        {
            task_for.push_back(0);
            not_A_idx_for.push_back(idx);
        }
            answer += min(ch - 'A','Z' - ch +1);
            idx++;
    }
    if(find(task_for.begin(), task_for.end(), 1) == task_for.end())
        return answer + task_for.size()-1;

    not_A_idx_back = not_A_idx_for;
    int size = task_for.size()-1;
    while(not_A_idx_for.size() > 0)
    {
        if(not_A_idx_for.size() == 1)
        {
            min_move = min(min_move, 2*not_A_idx_for[0] + 1);
            break;
        }
        else
        {
            min_move = min(min_move, 2*not_A_idx_for[0] + 1 + size - not_A_idx_for[1]);
            not_A_idx_for.erase(not_A_idx_for.begin());
        }
    }
    
    int size_back = not_A_idx_back.size() -1 ;
    while(not_A_idx_back.size() > 0)
    {
        if(not_A_idx_back.size() == 1)
        {
            min_move = min(min_move, not_A_idx_back.size()-not_A_idx_back[0] + 1);
            break;
        }
        else
        {
            min_move = min(min_move, 2*(not_A_idx_back[size_back] - not_A_idx_back[size_back-1]) + not_A_idx_back[0] + 1 );
            not_A_idx_back.pop_back();
        }
    }
    
    
    if(min_move == 999)
        min_move = 0;
    return answer + min_move ;
}

/*

#include <string>
#include <vector>
#include <iostream>

#define min(a,b) ((a) > (b) ? (b) : (a))
using namespace std;

int solution(string name) {
    int answer = 0;
    vector<int> A_idx;
    int cnt =0;
    int temp_cnt =0;
    for(int i=0; i<name.size();i++)
    {
        if(name[i] == 'A')
        {
            A_idx.push_back(i);
            temp_cnt += 1;
        }   
        else
        {
            cnt++;
            cnt += temp_cnt;
            temp_cnt = 0;
        }
        answer+=min('Z'- name[i] + 1, name[i]-'A');
    }
    if(cnt == 0)
        return 0;
    
    int tmp_back_cnt = 99999;
    while(!A_idx.empty())
    {
        int back_cnt=0;
        int back_temp_cnt=0;
        int last_A = A_idx[A_idx.size()-1];
        A_idx.pop_back();    
        for(int j = name.size()-1 ; j>last_A; j--)
        {
            if(name[j] == 'A')
            {
                back_temp_cnt += 1;
            }
            else
            {
                back_cnt++;
                back_cnt += back_temp_cnt;
                back_temp_cnt = 0;
            }
        }
        if(last_A > 1)
            tmp_back_cnt = min(tmp_back_cnt, back_cnt+2*(last_A-1)+1);
        else
            tmp_back_cnt = min(tmp_back_cnt, back_cnt+1);
    }
    // 1. right search
    // 이렇게하는게 정방향이다...
    // 2. left search
    
    return answer + min(cnt-1,tmp_back_cnt-1);
}



    ABCDEFGHIJKLMNOPQRSTUVWXYZ
    1. cursor를 만들어.
     디폴트 cursor는 알파벳 'A' 앞에 위치.
    
    
    내가 만들고자 하는것은? 최소,,,




*/
