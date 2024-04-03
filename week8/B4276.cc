// Subject: Study of Algorithm with SSAFY
// ProblemNo: 4276
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
using namespace std;
using lld = long long;
#define MX 200000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

//0~9 1 | 0
//00~99 20 | 10
//000~999 300 | 110
//0000~9999 4000 | 1110

lld ten[13], zero[13], pre[13];
string n, m;

lld solve(string s, bool flag){
    int sz = s.size();
    if(sz == 1) return 1;
    lld ret = 0;
    for(int i = 0; i < s[0] - '0'; i++){
        if(!i){
            if(!flag) ret += pre[sz - 2];
            else ret += ten[sz - 2] * (sz - 1) + ten[sz - 1];
        }
        else ret += ten[sz - 2] * (sz - 1);
    }
    if(s[0] == '0') ret += stol(s.substr(1)) + 1;
    return ret + solve(s.substr(1), true);
}

int main(int argc, char** argv){
    fastio;
    
    ten[0] = pre[0] = 1;
    for(int i = 1; i < 13; i++){
        ten[i] = ten[i - 1] * 10;
        zero[i] = ten[i] + zero[i - 1];
        pre[i] = (i + 1) * ten[i] - zero[i];
    }
    while(true){
        cin >> n >> m;
        if(n == "-1") break;
        lld res = solve(m, 0);
        if(n != "0") res -= solve(to_string(stol(n) - 1), 0);
        cout << res << '\n';
    }

    return 0;
}

