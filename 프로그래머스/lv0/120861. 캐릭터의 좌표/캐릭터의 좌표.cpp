#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board) {
    vector<int> answer ;
    int x=0;
    int y=0;
    for(int i=0;i<keyinput.size();i++)
    {
        if(keyinput[i] =="left")
        {
            if(x-1 < -board[0]/2)
                continue;
            else
                x-=1;
        }
        else if(keyinput[i] =="right")
        {
            if(x+1 >board[0]/2)
                continue;
            else
                x+=1;
        }
        else if(keyinput[i] =="up")
        {
            if(y+1 >board[1]/2)
                continue;
            else
                y+=1;

        }
        else if(keyinput[i] =="down")
        {
            if(y-1 < -board[1]/2)
                continue;
            else
                y-=1;
        }
    }
    answer.push_back(x);
    answer.push_back(y);
    return answer;
}