// Subject: Study of Algorithm with SSAFY
// ProblemNo: B20529
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static int f(String x, String y){
        int ret = 0;
        for(int i = 0; i < 4; i++){
            if(x.charAt(i) != y.charAt(i)) ret++;
        }
        return ret;
    }
    
	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, res;
    static String v[];
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            if(N > 32) sb.append(0);
            else{
                v = new String[N];
                for(int i = 0; i < N; i++) v[i] = st.nextToken();
                res = 100000;
                for(int i = 0; i < N; i++){
                    for(int j = i + 1; j < N; j++){
                        for(int k = j + 1; k < N; k++){
                            res = Math.min(res, f(v[i], v[j]) + f(v[j], v[k]) + f(v[i], v[k]));
                        }
                    }
                }
                sb.append(res);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}