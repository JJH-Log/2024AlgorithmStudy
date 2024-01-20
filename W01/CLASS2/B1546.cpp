//Study of SSAFY
//ProblemNo: 1546
//Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 1000
#define MOD 1234567891
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N;
double T, M, v[MX];

int main() {
	fastio;
	
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> v[i];
        M = max(M, v[i]);
        T += v[i];
    }
    T = T / M / N * 100;
    cout << T;
    
	return 0;
}