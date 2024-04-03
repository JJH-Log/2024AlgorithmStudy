// Subject: Study of Algorithm with SSAFY
// ProblemNo: B11444
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static class Matrix{
        Long m[][];
        Matrix(int ...a){
            m = new Long[2][2];
            for(int i = 0; i < 4; i++) m[i / 2][i % 2] = new Long(a[i]);
        }
        void mul(Matrix p){
            Matrix tmp = new Matrix(0, 0, 0, 0);
            for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
            for(int k = 0; k < 2; k++)
            tmp.m[i][j] = ((tmp.m[i][j] + m[i][k] * p.m[k][j]) % MOD);
            for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
            m[i][j] = tmp.m[i][j];
        }
    }
    
    static Matrix solve(Long n){
        Matrix ret = new Matrix(1, 0, 0, 1);
        Matrix x = new Matrix(1, 1, 1, 0);
        while(n > 0){
            if(n % 2 == 1) ret.mul(x);
            x.mul(x); n /= 2;
        }
        return ret;
    }
    
	static final int MX = 10000;
	static final int MOD = 1000000007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Long N;
    static Matrix res;
    
    public static void main(String[] args) throws Exception{
        N = Long.parseLong(br.readLine());
        res = solve(N);
        System.out.println(res.m[1][0]);
    }
}