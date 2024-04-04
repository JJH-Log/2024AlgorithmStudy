// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9935
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
	static final int MX = 10000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String A, B;
    static int ptr, now;
    static char res[];
    
    public static void main(String[] args) throws Exception{
        A = br.readLine();
        B = br.readLine();
        res = new char[A.length()];
        
        for(int idx = 0; idx < A.length(); idx++){
            if(now != B.length()){
                if(A.charAt(idx) == B.charAt(now)) now++;
                else if(A.charAt(idx) == B.charAt(0)) now = 1;
                else now = 0;
                res[ptr++] = A.charAt(idx);
            }
            if(now == B.length()){
                ptr -= B.length();
                now = 0;
                for(int j = Math.max(0, ptr - B.length()); j < ptr; j++){
                    if(res[j] == B.charAt(now)) now++;
                    else if(res[j] == B.charAt(0)) now = 1;
                    else now = 0;
                }
            }
        }
        if(ptr == 0) sb.append("FRULA");
        else for(int i = 0; i < ptr; i++) sb.append(res[i]);
        System.out.print(sb);
        
    }
}