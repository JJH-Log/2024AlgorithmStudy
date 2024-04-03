// Subject: Study of Algorithm with SSAFY
// ProblemNo: B21736
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static class Pos{
        int x, y;
        Pos(int ...a){
            this.x = a[0];
            this.y = a[1];
        }
    }
    
	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, v[][], res, vtd[][];
    static String s;
    static Pos S;
    static ArrayDeque<Pos> queue = new ArrayDeque();
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new int[N][M];
        vtd = new int[N][M];
        
        for(int i = 0; i < N; i++){
            s = br.readLine();
            for(int j = 0; j < M; j++){
                char c = s.charAt(j);
                if(c == 'P') v[i][j] = 1;
                if(c == 'X') v[i][j] = 2;
                if(c == 'I') S = new Pos(i, j);
            }
        }
        
        vtd[S.x][S.y] = 1;
        queue.offer(S);
        
        while(!queue.isEmpty()){
            Pos now = queue.poll();
            for(int i = 0; i < 4; i++){
                int dx = now.x + "2011".charAt(i) - '1';
                int dy = now.y + "1120".charAt(i) - '1';
                if(dx < 0|| dx>= N || dy < 0 || dy >= M || vtd[dx][dy] > 0 || v[dx][dy] > 1) continue;
                res += v[dx][dy];
                vtd[dx][dy]++;
                queue.offer(new Pos(dx, dy));
            }
        }
        if(res == 0) System.out.print("TT");
        else System.out.print(res);
        
    }
}