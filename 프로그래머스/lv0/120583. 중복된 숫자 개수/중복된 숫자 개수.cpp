#include <string>
#include <vector>
#include <iostream>

using namespace std;


int solution(vector<int> array, int n) {
    int answer = 0;
    for(auto elem:array)
        if(elem == n)   answer++;
    
    return answer;
}