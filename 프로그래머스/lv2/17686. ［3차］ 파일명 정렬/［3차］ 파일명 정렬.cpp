#include <string>
#include <vector>
#include <string>
#include <iostream>
#include <algorithm>

using namespace std;
class my_class{
    public:
        int    idx;
        string head;
        int    num;
        string tail;
};

bool comp(my_class a, my_class b){
    if(a.head == b.head){
        if(a.num == b.num){
            return a.idx <b.idx;
        }
        else{
            return a.num < b.num;
        }
    }
    else{
        return a.head < b.head;
    }
}

vector<string> solution(vector<string> files) {
    vector<string> answer;
    vector<my_class> tmp;
    
    my_class* mine = new my_class[files.size()];
    for(int i=0;i<files.size();i++){
        mine[i].idx = i;
        int idx1=0;
        string tmp_str = "";
        while(!(48 <= files[i][idx1] && files[i][idx1] <=57)){ 
            tmp_str += toupper(files[i][idx1]);
            idx1++;
        }
        mine[i].head = tmp_str;
        int idx2 = idx1;
        while(48 <= files[i][idx2] && files[i][idx2] <=57){ 
            idx2++;
        }
        mine[i].num = stoi(files[i].substr(idx1,idx2));
        mine[i].tail = files[i].substr(idx2,files[i].size());
        tmp.push_back(mine[i]);
    }
    sort(tmp.begin(),tmp.end(),comp);
    for(int i=0;i<files.size();i++)
        answer.push_back(files[tmp[i].idx]);  
    return answer;
}