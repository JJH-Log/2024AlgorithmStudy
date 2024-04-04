//https://www.acmicpc.net/submit/12972
//author:asz2325
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
using lld = long long;
#define MX 250000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int gcd(int x, int y){
    if(!y) return x;
    return gcd(y, x % y);
}


int N;
int v[MX], now;
priority_queue<int> pq;
vector<int> res;

int main(int argc, char** argv){
    fastio;

    cin >> N;
    for(int i = 0; i < N * N; i++) cin >> v[i];
    sort(v, v + N * N, greater<int>());
    while(now < N * N){
        int ans = v[now++];
        for(int i = 0; i < res.size(); i++){
            int g = gcd(ans, res[i]);
            pq.push(g);
            pq.push(g);
        }
        while(now < N * N && !pq.empty() && (pq.top() == v[now])) pq.pop(), now++;
        res.push_back(ans);
    }
    for(auto ans : res) cout << ans << ' ';

    return 0;
}

