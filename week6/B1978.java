// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1978
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static boolean isPrime(int X){
        for(int i = 0; pr.get(i) * pr.get(i) <= X; i++){
            if(X % pr.get(i) == 0) return false;
        }
        return true;
    }

    static final int MX = 1000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> m = new HashMap();
    static int N, x, res, mark[];
    static ArrayList<Integer> pr = new ArrayList();
    
    public static void main(String[] args) throws Exception{
        pr.add(2);
        for(int i = 3; i <= 1000; i += 2) if(isPrime(i)) pr.add(i);
        mark = new int[1001];
        for(int x : pr) mark[x] = 1;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        res += mark[Integer.parseInt(st.nextToken())];
        
        System.out.print(res);
    }
}