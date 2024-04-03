// Subject: Study of Algorithm with SSAFY
// ProblemNo: B24449
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 500
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N, M, vtd[MX][MX];
string v[MX];
queue<pi> q;

int main(int argc, char** argv){
    fastio;
    
    cin >> N >> M;
    for(int i = 0; i < N; i++) cin >> v[i];
    
    q.push({0, 0});
    vtd[0][0] = 1;
    
    while(!q.empty()){
        pi now = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int dx = now.first + "2011"[i] - '1';
            int dy = now.second + "1120"[i] - '1';
            if(dx >= 0 && dx < N && dy >= 0 && dy < M
            && v[dx][dy] != v[now.first][now.second] && !vtd[dx][dy]){
                q.push({dx, dy});
                vtd[dx][dy] = vtd[now.first][now.second] + 1;
            }
        }
    }
    cout << vtd[N - 1][M - 1] - 1;
    
    
    
    return 0;
}
