#include <iostream>
#include <vector>
#include <string>
#define abs(a) ((a)>(0)?(a):(-a))

using namespace std;

vector<int> q1,q2,q3,q4;
vector<pair<int,int> > m;
int K, num, dir;
void init()
{
    for(int i=0;i<4;i++)
    {
        char num[9];
        cin.getline(num, 9,'\n');
        for(int j=0;j<8;j++)
        {
            if(i == 0)      q1.push_back(num[j] - '0');
            else if(i == 1) q2.push_back(num[j] - '0');
            else if(i == 2) q3.push_back(num[j] - '0');
            else            q4.push_back(num[j] - '0');
        }
    }
    scanf("%d",&K);
    for(int i=0;i<K;i++)
    {
        scanf("%d %d",&num, &dir);
        m.push_back(make_pair(num, dir));
    }
}

void rotate(int num, int dir)
{
    if(num == 1)      
    {
        if(dir == 1)
        {
            int tmp = q1[7];
            q1.pop_back();
            q1.insert(q1.begin(), tmp);
        }
        else
        {
            int tmp = q1[0];
            q1.erase(q1.begin());
            q1.push_back(tmp);
        }
    }
    else if(num == 2)
    {
        if(dir == 1)
        {
            int tmp = q2[7];
            q2.pop_back();
            q2.insert(q2.begin(), tmp);
        }
        else
        {
            int tmp = q2[0];
            q2.erase(q2.begin());
            q2.push_back(tmp);
        }

    }
    else if(num == 3) 
    {
        if(dir == 1)
        {
            int tmp = q3[7];
            q3.pop_back();
            q3.insert(q3.begin(), tmp);
        }
        else
        {
            int tmp = q3[0];
            q3.erase(q3.begin());
            q3.push_back(tmp);
        }
    }
    else           
    {
        if(dir == 1)
        {
            int tmp = q4[7];
            q4.pop_back();
            q4.insert(q4.begin(), tmp);
        }
        else
        {
            int tmp = q4[0];
            q4.erase(q4.begin());
            q4.push_back(tmp);
        }
    }
}

void find(int cur_num, int elem,int num, int dir)
{
    // 조건 하나 넣어야함 
    //cout << " cur_ num " << cur_num << "num: " << num <<"q2" << q2[0];
    if(cur_num+1 == num) // right
    {
        if(num ==2 && q2[6] != elem)
        {
            find(num, q2[2],num+1, -1*dir);
            rotate(num, dir);
        }
        else if(num == 3 && q3[6] != elem)
        {
            find(num, q3[2],num+1, -1*dir);
            rotate(num, dir);
        }
        else if(num == 4 && q4[6] != elem)
        {
            rotate(num, dir);
        }
    }
    else if(cur_num-1 == num)
    {
        if(num == 3 && q3[2] != elem)
        {
            find(num, q3[6],num-1, -1*dir);
            rotate(num, dir);
        }
        else if(num == 2 && q2[2] != elem)
        {
            find(num, q2[6],num-1, -1*dir);
            rotate(num, dir);
        }
        else if(num == 1 && q1[2] != elem)
        {
            rotate(num, dir);
        }
    }

}
int main()
{
    init();
    for(int i=0;i<m.size();i++)
    {
        for(int j=0;j<abs(m[i].second);j++)
        {
            if(m[i].first == 1)
            {
                find(1,q1[2] ,2, -1*(m[i].second)/(abs(m[i].second))); // 1st wheel
                rotate(1, (m[i].second)/(abs(m[i].second)));
            }
            else if(m[i].first == 2)
            {
                find(2,q2[2] ,3, -1*(m[i].second)/(abs(m[i].second))); // 2nd wheel
                find(2,q2[6] ,1, -1*(m[i].second)/(abs(m[i].second))); // 2nd wheel
                rotate(2, (m[i].second)/(abs(m[i].second)));
            }
            else if(m[i].first == 3)
            {
                find(3,q3[2] ,4, -1*(m[i].second)/(abs(m[i].second))); // 3rd wheel
                find(3,q3[6] ,2, -1*(m[i].second)/(abs(m[i].second))); // 3rd wheel
                rotate(3, (m[i].second)/(abs(m[i].second)));
            }
            else
            {
                find(4,q4[6] ,3, -1*(m[i].second)/(abs(m[i].second))); // 4th wheel
                rotate(4, (m[i].second)/(abs(m[i].second)));
            }
        }
    }
    cout << q1[0]*1 + q2[0]*2 + q3[0]*4 + q4[0]*8;
}

