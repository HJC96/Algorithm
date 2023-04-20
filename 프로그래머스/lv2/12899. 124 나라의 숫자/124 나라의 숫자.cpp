#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

string cal(int num){
    string triple="";
    while(num!=0){
        if((num-1) % 3 == 0) triple = '1' + triple;
        else if((num-1) % 3 == 1) triple = '2' + triple;
        else if((num-1) % 3 == 2) triple = '4' + triple;
        num=(num-1)/3;
    }
    //reverse(triple.begin(),triple.end());
   
    //if(num == 1) triple = '4' + triple;
    //else if(num == 2) triple = '2' + triple;
    
    return triple;

}

string solution(int n) {
    string answer = cal(n);
    return answer;
}