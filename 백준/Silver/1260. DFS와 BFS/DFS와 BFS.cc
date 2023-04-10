#include <iostream>
#include <queue>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int number = 1001;
int c[1001];
int d[1001];
vector <int > a[1002];
void dfs(int start)
{
	if (c[start]) return;
	c[start] = true;
	cout << start << ' ';
	int tmp = a[start].size();
	for (int i = 0; i < tmp; i++)
	{
		int y = a[start][i];
		dfs(y);
	}
}
void bfs(int start)
{
	queue<int> q;
	q.push(start);
	d[start] = true;
	while (!q.empty())
	{
		int x = q.front();
		q.pop();
		cout << x << " ";
		int tmp = a[x].size();
		for (int i = 0; i < tmp; i++)
		{
			int y = a[x][i];
			if (!d[y])
			{
				q.push(y);
				d[y] = true;
			}
		}
	}
}
int main(void) {
	int num1, num2, v;
	cin >> num1 >> num2 >> v;
	for (int i = 1; i < num2 + 1; i++)
	{
		int num3, num4;
		cin >> num3 >> num4;
		a[num3].push_back(num4);
		a[num4].push_back(num3);

	}
	for (int i = 1; i < num1 + 1; i++)
		sort(a[i].begin(), a[i].end());

	dfs(v);
	cout << "\n";
	bfs(v);
	return 0;
}