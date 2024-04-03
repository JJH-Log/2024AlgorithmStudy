// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2134
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 100000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

lld n, m, k, x, a[MX], b[MX], l, r, cnt, res;

int main(int argc, char** argv){
    fastio;
    
    cin >> n >> m >> k;
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < m; i++) cin >> b[i];
    while(l < n && r < m){
        res += min(a[l], b[r]) * (l + r + 2);
        cnt += min(a[l], b[r]);
        if(a[l] <= b[r]) b[r] -= a[l++];
        else a[l] -= b[r++];
    }
    cout << cnt << ' ' << res;
    
    
    return 0;
}
