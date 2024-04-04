//Study of SSAFY
//ProblemNo: 11403
//Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 100
#define MOD 1234567891
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int v[MX][MX], N, res[MX][MX];

int main() {
	fastio;
	
	cin >> N;
	for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) cin >> v[i][j], res[i][j] = (v[i][j]? 1 : 1e9);
	for(int k = 0; k < N; k++){
	    for(int i = 0; i < N; i++){
	        for(int j = 0; j < N; j++) res[i][j] = min(res[i][j], res[i][k] + res[k][j]);
	    }
	}
	for(int i = 0; i < N; i++) {
	    for(int j = 0; j < N; j++) cout << !(bool)(res[i][j] == 1e9) << ' ';
	    cout << '\n';
	}

	return 0;
}