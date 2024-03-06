// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1931
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static class Info{
        int s, e;
        Info(int ...a){
            this.s = a[0]; this.e = a[1];
        }
    }

    static final int MX = 1000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, x, y, res;
    static Info v[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new Info[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            v[i] = new Info(x, y);
        }
        Arrays.sort(v, (o1, o2) -> o1.e == o2.e? o1.s - o2.s : o1.e - o2.e);
        int ptr = 0;
        for(int i = 0; i < N; i++){
            if(ptr <= v[i].s){
                res++;
                ptr = v[i].e;
            }
        }
        System.out.print(res);
    }
}