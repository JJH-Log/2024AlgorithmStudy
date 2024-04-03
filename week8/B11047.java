// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11047
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int res, N, K, v[];
    
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        v = new int[N];
        for(int i = 0; i < N; i++) v[i] = Integer.parseInt(br.readLine());
        for(int i = N - 1; i >= 0; i--){
            res += (K / v[i]);
            K %= v[i];
        }
        System.out.print(res);
    }
}