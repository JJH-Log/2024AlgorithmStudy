// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11286
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
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        for(;N > 0; N--){
            x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.remove()).append('\n');
            } else pq.add(x);
        }
        System.out.print(sb);
    }
}
