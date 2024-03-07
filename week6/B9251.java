// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9251
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static final int MX = 1001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int dp[][], N, M;
    static String s1, s2;
    
    public static void main(String[] args) throws Exception{
        s1 = br.readLine(); N = s1.length();
        s2 = br.readLine(); M = s2.length();
        dp = new int[N + 1][M + 1];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(s1.charAt(i) == s2.charAt(j)) dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j]);
            }
        }
        for(int i = 0; i < N; i++) dp[i + 1][M] = Math.max(dp[i + 1][M], dp[i][M]);
        for(int j = 0; j < M; j++) dp[N][j + 1] = Math.max(dp[N][j + 1], dp[N][j]);
        System.out.print(dp[N][M]);
    }
}