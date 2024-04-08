// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9461
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
	static final int MX = 100000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> Math.abs(o1) == Math.abs(o2)? o1 - o2 : Math.abs(o1) - Math.abs(o2));
    static int N, x;
    static long pado[];
    
    public static void main(String[] args) throws Exception{
        pado = new long[101];
        pado[1] = pado[2] = pado[3] = 1;
        for(int i = 4; i <= 100; i++) pado[i] = pado[i - 2] + pado[i - 3];
        
        N = Integer.parseInt(br.readLine());
        for(;N > 0; N--){
            x = Integer.parseInt(br.readLine());
            sb.append(pado[x]).append('\n');
        }
        System.out.print(sb);
        
    }
}