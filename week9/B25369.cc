//https://www.acmicpc.net/submit/25369
//author:asz2325
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;
using lld = long long;
#define MX 100
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>


int res, A, N, x, num[7];
bool FLAG;

void backTracking(int idx, int val){
    if(FLAG) return;
    if(idx == N){
        if(val <= A) return;
        for(int i = 0; i < N; i++) cout << num[i] << ' ';
        FLAG = true;
        return;
    }
    for(int i = 1; i <= 9; i++){
        num[idx] = i;
        backTracking(idx + 1, val * i);
    }
}


int main(int argc, char** argv){
    fastio;

    A = 1;
    cin >> N;
    for(int i = 0; i < N; i++) cin >> x, A *= x;
    backTracking(0, 1);
    if(!FLAG) cout << -1;
    
    return 0;
}
