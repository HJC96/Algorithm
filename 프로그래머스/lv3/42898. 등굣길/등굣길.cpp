#include <string>
#include <vector>
#include <iostream>
#define MAX 1000000007
using namespace std;

int dp[101][101] = {0,};

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    for(auto elem:puddles){
        dp[elem[1]][elem[0]] = -1;
    }
    dp[1][1] = 1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(i==1 && j==1)    continue;
            if(dp[i][j] == -1)  {dp[i][j] = 0; continue;}
            dp[i][j] = (dp[i][j-1]+dp[i-1][j])%MAX;
        }    
    }
    
    return dp[n][m];
}