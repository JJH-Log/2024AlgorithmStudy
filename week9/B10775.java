// Subject: Study of Algorithm with SSAFY
// ProblemNo: B10775
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static int find(int X){
        if(X == par[X]) return X;
        return par[X] = find(par[X]);
    }
    static boolean merge(int a, int b){
        a = find(a); b = find(b);
        if(a == b) return false;
        if(a > b) return merge(b, a);
        par[b] = a;
        return true;
    }
	static final int MX = 10000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean FLAG;
    static int G, P, X, res, par[];
    
    public static void main(String[] args) throws Exception{
        
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        par = new int[G + 1];
        for(int i = 1; i <= G; i++) par[i] = i;
        
        for(int i = 0; i < P; i++){
            X = Integer.parseInt(br.readLine());
            if(FLAG) continue;
            X = find(X);
            if(X == 0) FLAG = true;
            else{
                merge(X, find(X - 1));
                res++;
            }
        }
        System.out.println(res);
        
    }
}