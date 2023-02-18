#include <algorithm>
#include <string>

using namespace std;

int solution(string name) {
    int answer = 0;
    int n = name.length();
    int turn = n - 1; //조이스틱을 한 방향으로 쭉 움직였을 때
    for (int i = 0; i < n; i++) {
        if (name[i] - 'A' < 14) answer += name[i] - 'A';
        else answer += 'Z' - name[i] + 1;

        int ind = i + 1;
        while (ind < n && name[ind] == 'A') ind++;

        turn = min(turn, i + n - ind + min(i, n - ind));
    }

    answer += turn;
    return answer;
}
// #include <string>
// #include <vector>
// #include <iostream>
// #include <algorithm>

// #define min(a,b) ((a) > (b) ? (b) : (a))
// using namespace std;



// int solution(string name) {
//     int answer = 0;
//     vector<int> task_forward;  // 0: remaining task 
//     vector<int> task_backward;  // 0: remaining task 

//     for(auto ch:name)
//     {
//         if(ch == 'A') task_forward.push_back(1);
//         else task_forward.push_back(0);
//         answer += min(ch - 'A','Z' - ch +1);
//     }
//     task_forward[0] = 1;
//     task_backward = task_forward;
    
//     int forward_move = 0;
//     while(find(task_forward.begin(), task_forward.end(),0) != task_forward.end())
//     {
//         task_forward[forward_move] = 1;
//         if(forward_move < task_forward.size() -1) forward_move++;
//     }
    
//     int backward_move = task_backward.size()-1;
//     while(find(task_backward.begin(), task_backward.end(),0) != task_backward.end())
//     {
//         task_backward[backward_move] = 1;
//         if(backward_move > 0) backward_move--;
//         //break;
//     }
    
    
    
//     return answer + min(forward_move, task_backward.size()-1 - backward_move );
// }

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
