// Subject: Study of Algorithm with SSAFY
// ProblemNo: B4153
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
    static int v[];
    
    public static void main(String[] args) throws Exception{
        
        v = new int[3];
        while(true){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 3; i++) v[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(v);
            if(v[2] == 0) break;
            sb.append(v[0] * v[0] + v[1] * v[1] == v[2] * v[2]? "right" : "wrong").append('\n');
        }
        System.out.print(sb);
    }
}