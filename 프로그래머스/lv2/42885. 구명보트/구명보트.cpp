#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool comp(int a, int b) {
    return a > b;
}

int solution(vector<int> people, int limit) {
    sort(people.begin(), people.end(), comp);

    int cnt = 0;
    int left = 0;
    int right = people.size() - 1;

    while (left <= right) {
        if (limit >= people[left] + people[right]) {
            left++;
            right--;
        } else {
            left++;
        }
        cnt++;
    }

    return cnt;
}
