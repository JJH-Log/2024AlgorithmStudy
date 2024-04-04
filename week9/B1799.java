// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1799
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static void backTracking(int idx){
        if(now + 2 * N - 1 - idx < result) return;
        if(idx == 2 * N - 1){
            result = Math.max(result, now);
            return;
        }
        
        for(int col : row[idx]){
            if(!lock[col]){
                lock[col] = true;
                now++;
                backTracking(idx + 1);
                now--;
                lock[col] = false;
            }
        }
        backTracking(idx + 1);
    } 
    
	static final int MX = 100000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> row[];
    static int N, v[][], now, result;
    static boolean lock[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        row = new ArrayList[2 * N - 1];
        lock = new boolean[2 * N - 1];
        for(int i = 0; i < 2 * N - 1; i++) row[i] = new ArrayList();
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) row[i + j].add(i - j + N - 1);
            }
        }
        backTracking(0);
        System.out.print(result);
    }
}