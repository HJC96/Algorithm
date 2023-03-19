#include <string>
#include <vector>

using namespace std;

int arr[201] = {0};

int solution(vector<vector<int>> lines) {
    int answer = 0;
    
    for(int i=0;i<lines.size();i++)
    {
        for(int j = lines[i][0]+100;j<lines[i][1]+100;j++)
            arr[j]++;
    }
    for(int i=0;i<201;i++)
        if(arr[i] > 1) answer++;
    
    return answer;
}


/*
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <set>

using namespace std;

int solution(vector<vector<int>> lines) {
    int answer =0;
//    lines.erase(unique(lines.begin(), lines.end()),lines.end());
    for(auto ch: lines)
    {
        for(auto c:ch)
            cout<< c <<endl;
    }
    int* arr = new int[201];
    for(int i=0;i<201;i++)
        *(arr+i) = 0;
    for(int i=0;i<lines.size();i++)
    {
        for(int j =lines[i][0];j<=lines[i][1];j++)
        arr[j+100]++;
    }
    
    for(int i=0;i<200;i++)
    {
        if(arr[i] >= 2 && arr[i+1] >= 2)
            answer++;
    }
    delete [] arr;
    return answer;
}

*/