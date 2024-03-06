// Subject: Study of Algorithm with SSAFY
// ProblemNo: B10816
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
    static HashMap<Integer, Integer> m = new HashMap();
    static int N, M, x;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            x = Integer.parseInt(st.nextToken());
            if(m.containsKey(x)) m.put(x, m.get(x) + 1);
            else m.put(x, 1);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());        
        for(int i = 0; i < M; i++){
            x = Integer.parseInt(st.nextToken());
            if(m.containsKey(x)) sb.append(m.get(x)).append(' ');
            else sb.append("0 ");
        }
        System.out.print(sb);
    }
}