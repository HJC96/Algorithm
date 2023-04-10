#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;
int n, m;
int visited[9] = { 0, };
int arr[9] = { 0, };
map<int,int> h;
vector<int> v;
void dfs(int start, int cur)
{
	if (cur == m)
	{
		for (int i = 0; i < m; i++)
			printf("%d ", arr[i]);
		printf("\n");
		return;
	}
	for(int i=start;i<v.size();i++)
	{
		arr[cur] = v[i];
		dfs(i, cur+1);
	}
}

void input()
{
	scanf("%d %d", &n, &m);
	for(int i=0;i<n;i++)
	{
		int tmp;
		scanf("%d", &tmp);
		h[tmp]++;
	}
}

int main()
{
	input();
	for(int i=0;i<10000;i++)
	{
		if(h[i]>=1)
			v.push_back(i);				
	}
	dfs(0, 0);
}

