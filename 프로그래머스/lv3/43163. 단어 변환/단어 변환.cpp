#include <string>
#include <vector>
#include <queue>

#define min(a,b) ((a) >(b) ? (b):(a))
#define pr pair<string,int>
using namespace std;

int compare(string begin, string word)
{
    int size = min(begin.size(), word.size());
    int value = 0;
    for(int i=0;i<size;i++)
    {
	    if(begin[i]-word[i] !=0)
	    	value++;
    }

    if(value > 1) return 0;
    else     	  return 1;
}

int solution(string begin, string target, vector<string> words) {
    int answer =0;
    queue<pr> q;
    int level = 0;
    q.push({begin,level});
     
    while(q.size()>0)
    {
        string front = q.front().first;
        int    level = q.front().second;
        if(front == target)
            return level;
        q.pop();
     
        vector<string> word = words;
        for(int i=0; i<word.size();i++)
        {
	        if(compare(front, word[i]) == 1)
            {
                int idx=0;
   	    	    q.push({word[i],level+1});

                while(idx<words.size() && words[idx] != word[i]) idx++;
                words.erase(words.begin()+idx); // 방문한 노드 제거
            }
        }
    }
    return answer;
}