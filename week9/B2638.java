// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2638
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static class Pos{
        int x, y;
        Pos(int ...a) {
            this.x = a[0];
            this.y = a[1];
        }
    }
    
	static final int MX = 10000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Pos> queue[];
    static int N, M, v[][], cnt[][], now, T;
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new int[N][M];
        cnt = new int[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
            v[i][j] = Integer.parseInt(st.nextToken());
        }
        queue = new ArrayDeque[2];
        queue[0] = new ArrayDeque();
        queue[1] = new ArrayDeque();
        
        queue[0].offer(new Pos(0, 0));
        cnt[0][0] = 2;
        
        while(true){
            boolean FLAG = false;
            while(!queue[now].isEmpty()){
                Pos p = queue[now].poll();
                for(int i = 0; i < 4; i++){
                    int dx = p.x + "2011".charAt(i) - '1';
                    int dy = p.y + "1120".charAt(i) - '1';
                    if(dx >= 0 && dx < N && dy >= 0 && dy < M && cnt[dx][dy] < 2){
                        cnt[dx][dy]++;
                        if(cnt[dx][dy] == 1 + v[dx][dy]) queue[now ^ v[dx][dy]].offer(new Pos(dx, dy));
                    }
                }
                FLAG = true;
            }
            if(!FLAG) break;
            T++;
            now ^= 1;
        }
        
        System.out.print(T - 1);
    }
}