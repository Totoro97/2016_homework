#include <cstdio>
#include <cstring>
#include <algorithm>
#define N 1000000
#define maxn (N + 10)
using namespace std;

int pri[maxn],mark[maxn],phi[maxn];
int top;
int main() {
	freopen("just.out","w",stdout);
	phi[1] = 0;
	for (int i = 2; i <= N; i++) {
		if (!mark[i]) {
			phi[i] = i - 1;
			pri[++top] = i;
		}
		for (int j = 1; j <= top && pri[j] * i <= N; j++) {
			mark[i * pri[j]] = 1;
			if (i % pri[j]) phi[i * pri[j]] = phi[i] * (pri[j] - 1);
			else { phi[i * pri[j]] = phi[i] * pri[j]; break; }
		}
	}
	for (int i = 1; i <= 1000; i++) printf("%d\n",phi[i]);
	return 0;
}
