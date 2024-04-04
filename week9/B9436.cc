//https://www.acmicpc.net/submit/9436
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

int N, T;
int v[MX], lock[MX];

int main(int argc, char** argv){
    fastio;

    while(true){
        cin >> N;
        if(!N) break;
        cin >> T;
        fill(v, v + N, 0);
        fill(lock, lock + N, 0);
        
        int idx = 0;
        int left = N;
        int tar;
        bool FLAG = true;
        while(FLAG){
            for(int i = 0; i < T; i++) {
                if(!lock[idx]) v[idx]++;
                else i--; 
                idx = (idx + 1) % N;
            }
            lock[(idx + N - 1) % N] = true; left--;
            FLAG = false;
            tar = -1;
            for(int i = 0; i < N; i++){
                if(lock[i]) continue;
                if(tar == -1) tar = i;
                else FLAG |= (v[tar] != v[i]);
            }
        }
        cout << left << ' ' << v[tar] << '\n';
        
    }
    
    return 0;
}
