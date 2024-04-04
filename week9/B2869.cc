//Study of SSAFY
//ProblemNo: 2869
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
  
/*
A + (A - B)(K - 1) >= V
(A - B)K >= (V - B)
K = (V-B + (A - B - 1)) / (A-B)
*/
lld A, B, V, K;

int main() {
	fastio;
	
	cin >> A >> B >> V;
	cout << ((V- B + (A - B - 1)) / (A - B));
    
	return 0;
}
