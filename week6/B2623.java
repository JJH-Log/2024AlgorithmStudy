// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2623
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static final int MX = 100101;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, K, x, y, cnt[];
    static ArrayList<Integer> gph[];
    static ArrayDeque<Integer> queue = new ArrayDeque();
    static ArrayDeque<Integer> res = new ArrayDeque();
    static boolean edge[][], vtd[];

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        edge = new boolean[N][N];
        gph = new ArrayList[N];
        cnt = new int[N];
        for(int i = 0; i < N; i++) gph[i] = new ArrayList();
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            x = -1;
            for(int j = 0; j < K; j++){
                y = Integer.parseInt(st.nextToken()); y--;
                if(x != -1 && !edge[x][y]) {
                    gph[x].add(y);
                    edge[x][y] = true;
                    cnt[y]++;
                }
                x = y;
            }
        }
        
        vtd = new boolean[N];
        for(int i = 0; i < N; i++) {
            if(cnt[i] == 0) {
                queue.offer(i);
                vtd[i] = true;
            }
        }
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            res.offer(now);
            for(int next : gph[now]){
                cnt[next]--;
                if(cnt[next] == 0){
                    queue.offer(next);
                    vtd[next] = true;
                }
            }
        }
        
        if(res.size() != N) System.out.print(0);
        else{
            while(!res.isEmpty()) sb.append(res.poll() + 1).append('\n');
            System.out.print(sb);
        }
        
    }
}
