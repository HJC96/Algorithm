#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int price) {
    int answer = price;
    if(price >= 500000) answer = 0.8 * answer;
    else if(price < 500000 && price >= 300000)  answer = 0.9 * answer;
    else if(price < 300000 && price >= 100000)   answer = 0.95 * answer;
    else answer = answer ;
    return int(answer);
}