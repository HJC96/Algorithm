#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers, string direction) {
    if(direction == "right")
    {
        int tmp = numbers[numbers.size()-1];
        numbers.pop_back();
        numbers.insert(numbers.begin(),tmp);
    }
    else
    {
        int tmp = numbers[0];
        numbers.erase(numbers.begin());
        numbers.push_back(tmp);
    }
    return numbers;
}