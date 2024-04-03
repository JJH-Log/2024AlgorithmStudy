// Subject: Study of Algorithm with SSAFY
// ProblemNo: B21396
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

int T, N, x, v[MX];
lld res;

int main(int argc, char** argv){
    fastio;
    
    cin >> T;
    while(T--){
        cin >> N >> x;
        for(int i = 0; i < N; i++) cin >> v[i];
        sort(v, v + N);
        for(int i = 0; i < N; i++){
            int l = lower_bound(v, v + N, x ^ v[i]) - v;
            int r = upper_bound(v, v + N, x ^ v[i]) - v;
            if(r <= i) continue;
            res += r - max(i + 1, l);
        }
        cout << res << '\n';
        res = 0;
    }  
    
    return 0;
}