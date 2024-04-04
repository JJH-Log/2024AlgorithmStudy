// Subject: Study of Algorithm with SSAFY
// ProblemNo: B14939
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static int simulate(int before){
        int ret = 0;
        int next = 0;
        for(int i = 0; i < 10; i++){
            int now = bulb[i] ^ next;
            next = 0;
            for(int j = 0; j < 10; j++){
                if(((before & (1 << j))) > 0) {
                    ret++;
                    now ^= button[j];
                    next ^= (1 << j);
                }
            }
            before = now;
        }
        return (before == 0? ret : MX);
    }
    
	static final int MX = 100000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean FLAG;
    static int button[] = {3, 7, 14, 28, 56, 112, 224, 448, 896, 768};
    static int bulb[];
    static String tmp;
    
    public static void main(String[] args) throws Exception{
        
        bulb = new int[10];
        for(int i = 0; i < 10; i++){
            tmp = br.readLine();
            for(int j = 0; j < 10; j++) if(tmp.charAt(j) == 'O') bulb[i] += (1 << j);
        }
        int result = MX;
        for(int i = 0; i < 1024; i++) result = Math.min(result, simulate(i));
        System.out.print((result == MX? -1 : result));
        
    }
}