#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string make_map(int num, int n)
{
    vector<char> tmp;
    string map = "";
    while(num>0)
    {
        if(num%2==0)    tmp.push_back(' ');
        else            tmp.push_back('#');
        num/=2;
    }
    while(tmp.size() != n) tmp.push_back(' ');
    
    for(auto ch:tmp) map = ch + map ;

    return map;
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    for(int i=0; i<n; i++)
    {
        int result = (arr1[i] | arr2[i]);
        answer.push_back(make_map(result, n));
    }
    
    return answer;
}
/*
["######","###  #","##  ##","#### #","######","### # "]
["######","###  #","##  ##"," #### "," #####","### # "]

["######","###  #","##  ##","####  ","##### ","### # "]
["######","###  #","##  ##"," #### "," #####","### # "]
*/