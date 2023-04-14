#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;
vector<pair<string,int>> pr;

bool comp(pair<string,int> a, pair<string,int> b)
{
    if(a.second > b.second) return true;
    else                    return false;
}

int main()
{
    int T;
    cin >> T;
    vector<string> ans;
    for(int i=0;i<T;i++){
        int num;
        cin >> num;
        for(int j=0;j<num;j++){
            string st= "";
            int n;
            cin >> st >> n;
            pr.push_back({st,n});
        }
        sort(pr.begin(),pr.end(),comp);
        ans.push_back(pr[0].first);
    }
    for(auto a:ans) cout << a <<"\n";
}