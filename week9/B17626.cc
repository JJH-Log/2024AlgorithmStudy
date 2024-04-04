//Study of SSAFY
//ProblemNo: 17626
//Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 50001
#define MOD 1234567891
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N, vtd[MX];
queue<int> q;

int main() {
	fastio;
	
	q.push(0);
	while(!q.empty()){
	    int now = q.front(); q.pop();
	    for(int i = 1; now + i * i < MX; i++){
	        if(!vtd[now + i * i]){
	            vtd[now + i * i] = vtd[now] + 1;
	            q.push(now + i * i);
	        }
	    }
	}
	cin >> N;
	cout << vtd[N];

	return 0;
}