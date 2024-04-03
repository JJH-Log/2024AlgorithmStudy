// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1967
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static class Info{
        int tar, cost;
        Info(int ...a){
            this.tar = a[0];
            this.cost = a[1];
        }
    }
    
    static void dfs(int now, int parent){
        for(Info next : gph[now]){
            if(next.tar == parent) continue;
            dist[next.tar] = dist[now] + next.cost;
            dfs(next.tar, now);
        }
        if(dist[res] < dist[now]) res = now;
    }
    
	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Info> gph[];
    static int N, x, y, d, res, dist[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        gph = new ArrayList[N];
        
        for(int i = 0; i < N; i++) gph[i] = new ArrayList();
        
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); x--;
            y = Integer.parseInt(st.nextToken()); y--;
            d = Integer.parseInt(st.nextToken());
            gph[x].add(new Info(y, d));
            gph[y].add(new Info(x, d));
        }
        dist = new int[N]; dfs(res, -1);
        dist = new int[N]; dfs(res, -1);
        System.out.print(dist[res]);
    }
}