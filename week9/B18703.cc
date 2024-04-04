//https://www.acmicpc.net/submit/18703
//author:asz2325
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;
using lld = long long;
#define MX 55
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>


int T, N, x;
string s;

int main(int argc, char** argv){
    fastio;

    cin >> T;
    while(T--){
        map<string, int> m;
        cin >> N;
        while(N--){
            cin >> s >> x;
            if(m.count(s)) m[s] = min(m[s], x);
            else m[s] = x;
        }
        vector<int> ans;
        for(auto val : m) ans.push_back(val.second);
        sort(ans.begin(), ans.end());
        for(auto val : ans) cout << val << ' ';
        cout << '\n';
    }
    
    return 0;
}
