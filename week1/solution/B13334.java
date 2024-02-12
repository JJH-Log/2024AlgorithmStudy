// Subject: Study of Algorithm with SSAFY
// ProblemNo: 13334
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

class Query implements Comparable<Query>{
    long pos;
    int inout, idx; //in: 1, out: -1
    Query(long pos, int inout, int idx){
        this.pos = pos;
        this.inout = inout;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Query q) {
        if(this.pos == q.pos) return this.inout - q.inout;
        return (int)(this.pos - q.pos);
    }
}

        
public class Main {

    static final int MX = 100000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, D, x, y, res, cnt, chk[];
    static ArrayList<Query> v = new ArrayList();
    
    static int insert(long s, long e, int idx){
        if(s > e) return insert(e, s, idx);
        v.add(new Query(s, 1, idx));
        v.add(new Query(e, -1, idx));
        return 0;
    }
    
    static int custom_lower_bound(long key){
        int lo = 0, hi= 2 * N - 1, ret = 2 * N;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(key <= v.get(mid).pos){
                ret = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ret;
    }
    
    static int custom_upper_bound(long key){
        int lo = 0, hi= 2 * N - 1, ret = 2 * N;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(key < v.get(mid).pos){
                ret = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ret;
    }
    
    static void push(int now){
        int idx = v.get(now).idx;
        if(v.get(now).inout == 1) chk[idx]++;
        else {
            chk[idx]--;
            if(chk[idx] == 0) {
                cnt++;
                res = Math.max(res, cnt);
            }
        }
    }
    static void pop(int now){
        if(v.get(now).inout == 1){
            if(chk[v.get(now).idx] == 0) cnt--;
            chk[v.get(now).idx]--;
        }
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        chk = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            insert(x, y, i);
        }
        D = Integer.parseInt(br.readLine());
        Collections.sort(v);
        int l = 0, r = 0;
        
        for(; r < 2 * N; pop(l++)){
            int tar = custom_upper_bound(v.get(l).pos + D);
            while(r < tar) push(r++);
        }
        System.out.println(res);
    }
}