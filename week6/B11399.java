// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11399
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static final int MX = 1000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int v[], N, total, res;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        v = new int[N];
        for(int i = 0; i < N; i++) v[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(v);
        
        for(int i = 0; i < N; i++){
            total += v[i];
            res += total;
        }
        System.out.print(res);
    }
}