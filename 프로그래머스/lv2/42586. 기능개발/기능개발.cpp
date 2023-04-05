#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    while(!progresses.empty())
    {
        int cnt = 0;
        if(progresses[0] >= 100)
        {
            while(!progresses.empty() && progresses[0] >= 100)
            {
                cnt++;
                progresses.erase(progresses.begin());
                speeds.erase(speeds.begin());
            }
            answer.push_back(cnt);
        }
        for(int i=0; i<progresses.size();i++)
            progresses[i] += speeds[i] ;
    }
    
    return answer;
}


/*

예제 1)
남은 진행률: 7 70 45
     속도: 1 30 5


예제 2)
남은 진행률: 5 10 1 1 20 1 


핵심 -> 병렬 처리..

특징: 큐(앞에께 끝나야 뒤에꺼 처리 가능), 병렬 처리
-> 결국 한번에 몇개를 출력하는지를 리턴해야함.
-> 첫번째꺼가 완료될때까지, 다른 나머지녀석들이 완료되는게 어디까지인지를 구해야함..
1. 첫번째꺼 진행률 올림
2. 나머지것들 진행률 다 같이 올림
1. 첫번째꺼 진행률 올림
2. 나머지것들 진행률 다 같이 올림
...
만약 첫번째께 100이 되었다.
 나머지것들중 100이 안된것을 찾고, 그 이전까지의 개수를 찾아서 카운트
 1번 다시 반복. 언제까지 ? 큐가 빌때까지
 

 


*/