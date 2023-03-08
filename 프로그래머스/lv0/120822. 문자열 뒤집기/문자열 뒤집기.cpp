#include <string>
#include <vector>

using namespace std;



string solution(string my_string) {
    string answer = "";
    for(int i=0;i<my_string.size();i++)
        answer.push_back(my_string[my_string.size()-1-i]);
    return answer;
}