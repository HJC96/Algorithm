#include <string>
#include <vector>

using namespace std;

int sum_(const vector<int>& num) {
    int ans = 0;
    for (int i = 0; i < num.size(); i++)
        ans += num[i];
    return ans;
}

vector<int> solution(int num, int total) {
    vector<int> answer;

    // 초기 범위 설정
    for (int i = 1; i <= num; i++)
        answer.push_back(i);

    // 총합이 total보다 작은 경우 범위를 오른쪽으로 이동
    while (sum_(answer) < total) {
        answer.erase(answer.begin());
        answer.push_back(++num);
    }

    // 총합이 total이 아닌 경우 범위를 왼쪽으로 이동
    while (sum_(answer) != total) {
        answer.pop_back();
        answer.insert(answer.begin(), answer[0] - 1);
    }

    return answer;
}
