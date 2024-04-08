//Study of SSAFY
//ProblemNo: 1654
//Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 10000
#define MOD 1234567891
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

lld K, N, res;
lld v[MX];

int main() {
	fastio;
	
	cin >> K >> N;
	for(int i = 0; i < K; i++) cin >> v[i];
	lld lo, hi;
	lo = 1; hi = 1e12;
	
	while(lo <= hi){
	    lld mid = (lo + hi) / 2;
	    lld ret = 0;
	    for(int i = 0; i < K; i++) ret += v[i] / mid;
	    if(ret >= N){
	        res = mid;
	        lo = mid + 1;
	    }
	    else hi = mid - 1;
	}
	cout << res;
    
	return 0;
}