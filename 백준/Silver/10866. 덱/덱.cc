#include <iostream>
#include <vector>
#include <cstring>
using namespace std;


vector<int> Deque;

void push_front(int num)
{
    Deque.insert(Deque.begin(),num);
}

void push_back(int num)
{
    Deque.push_back(num);
}

int size()
{
    return Deque.size();
}

int pop_front()
{
    if(size() == 0)
        return -1;
    int result = Deque[0];
    Deque.erase(Deque.begin());    
    return result;
}

int pop_back()
{
    if(size() == 0)
        return -1;
    int result = Deque[Deque.size()-1];
    Deque.pop_back();
    return result;
}



int front()
{
    if(size() == 0)
        return -1;
    return Deque.front();
}

int back()
{
    if(size() == 0)
        return -1;
    return Deque.back();
}

int empty()
{
    if(size() == 0)
        return 1;
    else
        return 0;
}

int main()
{
    int num;
    vector<int> ans;
    char cmd[16] = {0};
    scanf("%d", &num);

    for(int i=0; i<num;i++)
    {
        int integer;
        scanf("%s", cmd);
        if(strcmp(cmd, "push_back") == 0)
        {
            scanf("%d", &integer);
            push_back(integer);
        }
        if(strcmp(cmd, "push_front") == 0)
        {
            scanf("%d", &integer);
            push_front(integer);
        }
        if(strcmp(cmd, "pop_front") == 0)
            ans.push_back(pop_front());
        if(strcmp(cmd, "pop_back") == 0)
            ans.push_back(pop_back());
        if(strcmp(cmd, "size") == 0)
            ans.push_back(size());
        if(strcmp(cmd, "empty") == 0)
            ans.push_back(empty());
        if(strcmp(cmd, "front") == 0)
            ans.push_back(front());
        if(strcmp(cmd, "back") == 0)
            ans.push_back(back());
    }
    vector<int>::iterator iter;
    for(iter=ans.begin();iter!=ans.end();iter++)
        printf("%d\n", *iter);
}