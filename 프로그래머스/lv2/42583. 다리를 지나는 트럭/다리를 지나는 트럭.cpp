#include <string>
#include <vector>
#include <queue>

using namespace std;

int queue_sum(vector<int> q)
{
    int sum = 0;
    for(int i=0;i<q.size();i++)
        sum += q[i];
    return sum;
}


int solution(int bridge_length, int weight, vector<int> truck_weights) {
    vector<int> passing;
    vector<int> wait = truck_weights;
    int time = 1;    
    passing.push_back(wait[0]);
    wait.erase(wait.begin());
    while(1)
    {
        if(passing.size() == bridge_length)
        {
	        if(queue_sum(passing) == 0)
		        break;	
	        passing.erase(passing.begin());
        }
        if(wait.size()>0)
        {
            if(queue_sum(passing) + wait[0] <= weight && passing.size() +1 <= bridge_length)
            {
                passing.push_back(wait[0]);
                wait.erase(wait.begin());
                time++;
                continue;
            }
        }
        passing.push_back(0);
        time++;
    }  
    
    return time;
}

/*

1. wait q에서 앞원소 제거
2. processing에 삽입
-----------------------
-. 만약 processing에.size == 길이
	if(합 == 0)
		break
	앞의 것 제거

- if wait큐가 있다면
	. if wait[0]를 더했을때 길이가 brige_length?
	. if weight[0]를 더했을때 무게가 ?
	. 그렇다면 더해주고
	. time++;
	. continue;
아니라면 다리길이에 0을 push
. time++;




if(wait.size()>0)
{
	if()

}
		processing		wait
		7				4 5 6   t = 1
		7 0				4 5 6   t = 2
		0 4 			5 6 	t = 3
		4 5 			6		t = 4
		5 0				6		t = 5
		0 6						t = 6
		6 0						t = 7
		0 0						t = 8
		
		






-> seg fault


*/