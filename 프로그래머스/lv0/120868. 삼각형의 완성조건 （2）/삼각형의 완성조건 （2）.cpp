#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> sides) {
    int answer = 0;
    // scenario 1
    sort(sides.begin(),sides.end());
    int end = sides[sides.size()-1];
    int start = sides[0];
    for(int i=1; i<end+1;i++)
    {
        if(end < i + start)
            answer++;
    }
    
    
    // scenario 2
    
    for(int i=end+1; i< start + end;i++)
    {
        answer++;
    }
    return answer;
}

/*
1. 가장 긴 변을 인풋에서 선택하는 경우
2. 가장 긴 변을 뽑는 경우

*/