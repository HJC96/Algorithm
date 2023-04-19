#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int answer;
const char kakao[8] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
bool visited[8];

vector<char> order;

void init(){
    answer =0;
    for(int i=0;i<8;i++)
        visited[i] =false;
     order.clear();
}

int dist(char A, char B, vector<char> k){
    int idx1=0; int idx2=0;
    while(k[idx1] != A) idx1++;
    while(k[idx2] != B) idx2++;
    return abs(idx1-idx2)-1;
}


void dfs(int n, vector<string> data){
    if(n==8){
        for(int i=0;i<data.size();i++){
            if(data[i][3] == '>' && (dist(data[i][0],data[i][2], order) <= data[i][4] - '0')) return;
            else if(data[i][3] == '=' && (dist(data[i][0],data[i][2], order) != data[i][4] - '0')) return;
            else if(data[i][3] == '<' && (dist(data[i][0],data[i][2], order) >= data[i][4] - '0')) return;  
        }
        answer++;
        return ; 
    }
    
    for(int i=0;i<8;i++){
        if(!visited[i]){
            visited[i] = true;
            order.push_back(kakao[i]);
            dfs(n+1,data);
            visited[i] = false;
            order.pop_back();
        }
    }
}

int solution(int n, vector<string> data) {
    init();
    dfs(0,data);
    return answer;
}