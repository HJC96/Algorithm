#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;


long long max_T(vector<int> times_){
    int max_t = times_[0];
    for(int elem:times_){
        if(elem > max_t)
            max_t = elem;
    }
    return max_t;
}

long long get_person(vector<int> tim, long long mid){
    long long person=0;
    for(int i=0;i<tim.size();i++){
        person += mid/tim[i];
    }
    return person;
}
long long solution(int n, vector<int> times) {
    long long answer = 0;
    long long MAXT = max_T(times)*n;
    long long MINT = 0;
    while(MINT<=MAXT){
        long long mid = (MINT + MAXT)/2;
        long long person=get_person(times, mid);
        
        if(person >= n)
            MAXT = mid-1;
        else if(person < n)
            MINT = mid+1;
    }
    
    return MAXT+1;
}