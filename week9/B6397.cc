//https://www.acmicpc.net/submit/6397
//author:asz2325
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;
using lld = long long;
#define MX 202
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

vector<string> streams;
string s;
vector<int> mark;
int N, M;
string ty, codes, result;

int bits[MX][MX], total[MX][MX];

string encode(int x1, int y1, int x2, int y2){
    if(x1 == x2 || y1 == y2) return "";
    int cnt = 0;
    for(int i = x1; i < x2; i++) for(int j = y1; j < y2; j++) cnt += bits[i][j];
    if(cnt == 0) return "0";
    if(cnt == (x2 - x1) * (y2 - y1)) return "1";
    string ret = "D";

    int midx = (x1 + x2 + 1) / 2;
    int midy = (y1 + y2 + 1) / 2;
    ret += encode(x1, y1, midx, midy);
    ret += encode(x1, midy, midx, y2);
    ret += encode(midx, y1, x2, midy);
    ret += encode(midx, midy, x2, y2);
    return ret;
}

int decode(int idx, int x1, int y1, int x2, int y2){
    if(x1 == x2 || y1 == y2) return idx;
    if(codes[idx] != 'D'){
        for(int i = x1; i < x2; i++) for(int j = y1; j < y2; j++) bits[i][j] = codes[idx] - '0';
        return idx + 1;
    }
    int midx = (x1 + x2 + 1) / 2;
    int midy = (y1 + y2 + 1) / 2;
    idx++;
    idx = decode(idx, x1, y1, midx, midy);
    idx = decode(idx, x1, midy, midx, y2);
    idx = decode(idx, midx, y1, x2, midy);
    idx = decode(idx, midx, midy, x2, y2);
    return idx;
}

int main(int argc, char** argv){
    fastio;

    while(true){
        cin >> s;
        if(s == "#") break;
        streams.push_back(s);
    }
    for(int i = 0; i < streams.size(); i++) if(streams[i] == "B" || streams[i] == "D") mark.push_back(i);
    mark.push_back(streams.size());
    
    for(int i = 0; i < mark.size() - 1; i++){
        ty = streams[mark[i]];
        N = stoi(streams[mark[i] + 1]);
        M = stoi(streams[mark[i] + 2]);
        
        cout << (ty == "B" ? "D" : "B");
        for(int j = 0; j < 4 - streams[mark[i] + 1].size(); j++) cout << ' ';
        cout << N;
        for(int j = 0; j < 4 - streams[mark[i] + 2].size(); j++) cout << ' ';
        cout << M << '\n';
        
        codes = "";
        for(int j = mark[i] + 3; j < mark[i + 1]; j++) codes += streams[j];
        
        if(ty == "B") {
            for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) bits[i][j] = codes[i * M + j] - '0';
            result = encode(0, 0, N, M);
        }
        else {
            decode(0, 0, 0, N, M);
            result = "";
            for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) result += (bits[i][j] + '0');
        }
        for(int i = 0; i < result.size(); i++){
            cout << result[i];
            if(i % 50 == 49) cout << '\n';
        }
        if(result.size() % 50) cout << '\n';
    }
    
    return 0;
}
