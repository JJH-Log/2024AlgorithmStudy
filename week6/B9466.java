// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9466
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int dfs(int now){
        if(vtd[now]) {
            if(cycle[now] != MX) return -1;
            return now;
        }
        vtd[now] = true;
        cycle[now] = dfs(to[now]);
        return (cycle[now] == now)? -1 : cycle[now];
    }

    static final int MX = 100101;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int res, T, N, to[], cycle[];
    static boolean vtd[];

    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            
            to = new int[N];
            cycle = new int[N];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) { 
                to[i] = Integer.parseInt(st.nextToken()); to[i]--;
                cycle[i] = MX;
            }
            
            vtd = new boolean[N];
            for(int i = 0; i < N; i++) if(!vtd[i]) dfs(i);
            
            res = 0;
            for(int i = 0; i < N; i++) if(cycle[i] == -1) res++;
            
            sb.append(res).append("\n");
        }
        System.out.print(sb);
        
    }
}