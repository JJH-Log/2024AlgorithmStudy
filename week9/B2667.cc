//Study of SSAFY
//ProblemNo: 2667
//Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 100
#define MOD 1234567891
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N;
string v[25];
bool vtd[25][25];
vector<int> res;

bool inRange(int x, int y) { return x >= 0 && x < N && y >= 0 && y < N; }

int dfs(int x, int y){
    int ret = 1;
    for(int i = 0; i < 4; i++){
        int dx = x + "2011"[i] - '1';
        int dy = y + "1120"[i] - '1';
        if(inRange(dx, dy) && !vtd[dx][dy] && v[dx][dy] == '1'){
            vtd[dx][dy] = true;
            ret += dfs(dx, dy);
        }
    }
    return ret;
}

int main() {
	fastio;
	
	cin >> N;
	for(int i = 0; i < N; i++) cin >> v[i];
	for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) if(v[i][j] == '1' && !vtd[i][j]) vtd[i][j] = true, res.push_back(dfs(i, j));
    sort(res.begin(), res.end());
    cout << res.size() << '\n';
    for(auto r : res) cout << r << '\n';

	return 0;
}