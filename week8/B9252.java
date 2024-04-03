// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9252
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static void update(int x, int y, int val, int dir){
        dp[x][y] = val;
        dp2[x][y] = dir;
    }
    
	static final int MX = 10000;
	static final int MOD = 1000000007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String A, B, result;
    static int N, M, dp[][], dp2[][], x, y;
    
    public static void main(String[] args) throws Exception{
        A = br.readLine(); N = A.length();
        B = br.readLine(); M = B.length();
        dp = new int[N + 1][M + 1];
        dp2 = new int[N + 1][M + 1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                if(i < N && dp[i + 1][j] < dp[i][j]) update(i + 1, j, dp[i][j], 0);
                if(j < M && dp[i][j + 1] < dp[i][j]) update(i, j + 1, dp[i][j], 1);
                if(i < N && j < M && A.charAt(i) == B.charAt(j) && dp[i + 1][j + 1] < dp[i][j] + 1) update(i + 1, j + 1, dp[i][j] + 1, 2);
            }
        }
        System.out.println(dp[N][M]);
        result = ""; x = N; y = M;
        while(x > 0 && y > 0){
            if(dp2[x][y] == 0) x--;
            else if(dp2[x][y] == 1) y--;
            else{
                x--; y--;
                result += A.charAt(x); 
            }
        }
        sb.append(result);
        System.out.print(sb.reverse());
    }
}