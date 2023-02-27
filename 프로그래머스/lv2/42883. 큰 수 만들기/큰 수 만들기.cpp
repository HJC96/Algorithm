#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
	int idx = 0;
	while(k>0 && idx<number.size())
	{
		if(number[idx] < number[idx+1])
		{
			number.erase(number.begin()+idx);
			idx = 0;
			k--;
		}
        else
        {
            if(idx == number.size()-2 && number[idx] >= number[idx+1])
            {
                number.erase(number.begin()+idx+1);
			    idx = 0;
			    k--;
                continue;
            }
		    idx++;
        }
	}
    return number;
}