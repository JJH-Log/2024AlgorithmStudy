// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11726
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static final int MX = 1001;
    static final int MOD = 10007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, v[];
    
    public static void main(String[] args) throws Exception{
        v = new int[MX];
        v[0] = v[1] = 1;
        N = Integer.parseInt(br.readLine());
        
        for(int i = 2; i <= N; i++) v[i] = (v[i - 1] + v[i - 2]) % MOD;
        System.out.print(v[N]);
    }
}