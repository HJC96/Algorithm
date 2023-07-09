#include <stdio.h>
#include <algorithm>
using namespace std;

int abs(int a) { return a < 0 ? -a : a; }
int n, m, a[1001], b[1001], d[1001][1001];

int main() {
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) scanf("%d", a + i);
	for (int i = 1; i <= m; i++) scanf("%d", b + i);

	sort(a + 1, a + n + 1);
	sort(b + 1, b + m + 1);

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			d[i][j] = d[i - 1][j - 1] + abs(a[i] - b[j]);
			if (i > j) d[i][j] = min(d[i][j], d[i - 1][j]);
			if (i < j) d[i][j] = min(d[i][j], d[i][j - 1]);
		}
	}

	printf("%d", d[n][m]);

	return 0;
}