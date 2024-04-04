// Subject: Study of Algorithm with SSAFY
// ProblemNo: B12913
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 55
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct info{
    int d, n, k;
};

struct cmp{
    bool operator()(info a, info b){
        return a.d > b.d;
    }
};

priority_queue<info, vector<info>, cmp> pq;
int N, K, half, result, cost[MX][MX], dist[MX][MX];
string s;

int main(int argc, char** argv){
    fastio;
    
    cin >> N >> K;
    for(int i = 0; i < N; i++){
        cin >> s;
        for(int j = 0; j < N; j++) cost[i][j] = s[j] - '0';
    }
    for(int i = 0; i < N; i++)
    for(int j = 0; j <= K; j++)
    dist[i][j] = 1e9;
    
    
    dist[0][0] = 0;
    pq.push({dist[0][0], 0, 0});
    
    while(!pq.empty()){
        info now = pq.top(); pq.pop();
        if(dist[now.n][now.k] != now.d) continue;
        
        for(int next = 0; next < N; next++){
            if(next == now.n) continue;
            if(dist[next][now.k] > now.d + 2 * cost[now.n][next]){
                dist[next][now.k] = now.d + 2 * cost[now.n][next];
                pq.push({dist[next][now.k], next, now.k});
            }
            if(now.k == K) continue;
            if(dist[next][now.k + 1] > now.d + cost[now.n][next]){
                dist[next][now.k + 1] = now.d + cost[now.n][next];
                pq.push({dist[next][now.k + 1], next, now.k + 1});
            }
        }
    }
    result = 1e9;
    for(int i = 0; i <= K; i++) result = min(result, dist[1][i]);
    cout << (result / 2) << (result % 2? ".5":"");
    
    return 0;
}


