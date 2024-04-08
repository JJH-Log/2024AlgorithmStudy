//Study of SSAFY
//ProblemNo: 11651
//Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 100000
#define MOD 1234567891
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N;
pi v[MX];

int main() {
	fastio;
	
	cin >> N;
    for(int i = 0; i < N; i++) cin >> v[i].second >> v[i].first;
    sort(v, v + N);
    for(int i = 0; i < N; i++) cout << v[i].second << ' ' << v[i].first << '\n';
    
	return 0;
}