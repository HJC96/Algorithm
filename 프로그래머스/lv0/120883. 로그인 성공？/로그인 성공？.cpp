#include <string>
#include <vector>

using namespace std;

string state = "fail";
string solution(vector<string> id_pw, vector<vector<string>> db) {
    string answer = "";
    for(int i=0;i<db.size();i++)
    {
        if(db[i][0] == id_pw[0])
        {
            state = "wrong pw";
            if(db[i][1] == id_pw[1])
            {
                state = "login";
            }
        }
    }
    answer = state;
    return answer;
}