// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9963
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static void backTracking(int cnt){
        if(cnt == N){
            res++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(v[i] != -1) continue;
            boolean FLAG = true;
            for(int j = 0; FLAG && j < N; j++){
                if(v[j] != -1 && (Math.abs(j - i) == (cnt - v[j]))) FLAG = false;
            }
            if(!FLAG) continue;
            v[i] = cnt;
            backTracking(cnt + 1);
            v[i] = -1;
        }
    }
    
	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int res, N, v[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new int[N];
        for(int i = 0; i < N; i++) v[i] = -1;
        backTracking(0);
        System.out.print(res);
    }
}