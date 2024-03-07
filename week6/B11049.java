// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11049
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
    static int N;
    static long v[][], dp[][];

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new long[N][2];
        dp = new long[N][N];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            v[i][0] = Long.parseLong(st.nextToken());
            v[i][1] = Long.parseLong(st.nextToken());
        }
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) if(i != j) dp[i][j] = 10_000_000_000L;
        
        for(int gap = 1; gap < N; gap++){
            for(int i = 0; i + gap < N; i++){
                for(int j = i; j < i + gap; j++){
                    if(v[j][1] == v[j + 1][0]){
                        dp[i][i + gap] = Math.min(dp[i][i + gap], dp[i][j] + dp[j + 1][i + gap] + v[i][0] * v[j][1] * v[i + gap][1]);
                    }
                } 
            }   
        }
        System.out.println(dp[0][N - 1]);
        
    }
}