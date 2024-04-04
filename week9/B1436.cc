//Study of SSAFY
//ProblemNo: 1436
//Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 20000
#define MOD 1234567891
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N;

bool check(int x){
    string p = to_string(x);
    return p.find("666") != string::npos;
}

int main() {
	fastio;
	
	cin >> N;
	int cnt = 1;
	while(N){ if(check(cnt++)) N--; }
	cout << cnt - 1;
    
	return 0;
}