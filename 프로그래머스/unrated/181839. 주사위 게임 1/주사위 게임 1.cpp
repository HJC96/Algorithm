#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int find_ans(int a, int b){
    if(a%2!=0 && b%2!=0){
        return pow(a,2) + pow(b,2);
    }
    
    else if(a%2!=0 || b%2!=0){
        return 2*(a+b);
    }
    else
        return abs(a-b);
}



int solution(int a, int b) {
    int answer = find_ans(a,b);
    return answer;
}