// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1043
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static int find(int X){
        if(X == par[X]) return X;
        return par[X] = find(par[X]);
    }
    
    static boolean merge(int a, int b){
        a = find(a); b = find(b);
        if(a == b) return false;
        if(a > b) return merge(b, a);
        par[b] = a;
        return true;
    }
    
	static final int MX = 10000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, par[];
    static ArrayList<Integer> party[];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        par = new int[N + 1];
        for(int i = 1; i <= N; i++) par[i] = i;
        party = new ArrayList[M];
        for(int i = 0; i < M; i++) party[i] = new ArrayList();
        
        
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        for(int i = 0; i < K; i++) par[Integer.parseInt(st.nextToken())] = 0;
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            for(int j = 0; j < K; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
                if(j > 0) merge(party[i].get(0), party[i].get(j));    
            }
        }
        int res = 0;
        for(int i = 0; i < M; i++) if(find(party[i].get(0)) != 0) res++;
        System.out.print(res);
    }
}