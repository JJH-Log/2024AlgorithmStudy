// Subject: Study of Algorithm with SSAFY
// ProblemNo: B17430
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 200000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct Pos{
    int x, y;
    Pos(){}
    Pos(int _x, int _y):x(_x),y(_y){}
    bool operator < (Pos tar){
        return x < tar.x;
    }
} p[MX];

int T, N;

bool solve(){
    vector<vector<int>> list;
    int before = MOD; int ptr = -1;
    for(int i = 0; i < N; i++){
        if(p[i].x != before){
            list.push_back(vector<int>());
            before = p[i].x;
            ptr++;
        }
        list[ptr].push_back(p[i].y);
    } ptr++;
    for(int i = 0; i < ptr; i++) sort(list[i].begin(), list[i].end());
    sort(list.begin(), list.end());
    before = 0;
    for(int i = 1; i < ptr; i++){
        if(list[before] != list[i]){
            if(i - before < 2) return false;
            before = i;
        }
    }
    return (ptr - before > 1);
}


int main(int argc, char** argv){
    fastio;
    
    cin >> T;
    while(T--){
        cin >> N;
        for(int i = 0; i < N; i++) cin >> p[i].x >> p[i].y;
        sort(p, p + N);
        bool FLAG_X = solve();
        for(int i = 0; i < N; i++) swap(p[i].x, p[i].y);
        sort(p, p + N);
        bool FLAG_Y = solve();
        cout << ((FLAG_X | FLAG_Y)? "":"NOT ") << "BALANCED\n";
    }
    
    return 0;
}
