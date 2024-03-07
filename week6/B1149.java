// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1149
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
    static int N, v[], dp1[], dp2[];

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dp1 = new int[3];
        v = new int[3];
        
        for(int i = 0; i < N; i++){
            dp2 = new int[3];
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < 3; j++) v[j] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 3; j++)
            for(int k = 0; k < 3; k++)
            if(j != k) dp2[k] = (dp2[k] == 0? dp1[j] + v[k] : Math.min(dp2[k], dp1[j] + v[k]));
            System.arraycopy(dp2, 0, dp1, 0, 3);
        }
        Arrays.sort(dp1);
        System.out.print(dp1[0]);
    }
}