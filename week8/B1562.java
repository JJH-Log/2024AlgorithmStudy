// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1562
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
	static final int MX = 10000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, dp[][][], res;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        dp = new int[N][1 << 10][10];
        for(int i = 1; i < 10; i++) dp[0][1 << i][i]++;
        
        for(int i = 0; i < N - 1; i++){
            for(int state = 0; state < (1 << 10); state++){
                for(int j = 0; j < 10; j++){
                    for(int d = 0; d < 2; d++){
                        int k = j + 1 - 2 * d; //j -> j + 1 or j - 1
                        if(k < 0 || k >= 10) continue;
                        dp[i + 1][state | (1 << k)][k] = (dp[i + 1][state | (1 << k)][k] + dp[i][state][j]) % MOD;
                    }
                }               
            }
        }
        for(int i = 0; i < 10; i++) res = (res + dp[N - 1][(1 << 10) - 1][i]) % MOD;
        System.out.print(res);
        
    }
}