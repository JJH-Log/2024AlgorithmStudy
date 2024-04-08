// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9461
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static class Block{
        String xpos, ypos;
        Block(String ...a){
            this.xpos = a[0];
            this.ypos = a[1];
        }
        int putBlock(int x, int y){
            int ret = 0;
            for(int i = 0; i < xpos.length(); i++){
                int dx = x + xpos.charAt(i) - '0';
                int dy = y + ypos.charAt(i) - '0';
                if(dx < 0 || dx >= N || dy < 0 || dy >= M) return -1;
                ret += v[dx][dy];
            }
            return ret;
        }    
    }
    
	static final int MX = 100000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)-> Math.abs(o1) == Math.abs(o2)? o1 - o2 : Math.abs(o1) - Math.abs(o2));
    static ArrayList<Block> blocks = new ArrayList();
    static int N, M, v[][];
    
    public static void main(String[] args) throws Exception{
        String xposList[] = {"0000", "0123", "0011", "0001", "0121", "0111", "0121",
                            "0122", "0001", "2100", "1110", "0122", "1110", "2100", "0001",
                            "0112", "0011", "0112", "0011"};
        String yposList[] = {"0123", "0000", "0101", "0121", "1110", "1210", "0001",
                            "0001", "2100", "1110", "0122", "1110", "2100", "0001", "0122",
                            "0011", "0112", "1100", "2110"};
        
        for(int i = 0; i < xposList.length; i++) blocks.add(new Block(xposList[i], yposList[i]));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new int[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) v[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int res = 0;
        for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
        for(Block block : blocks)
        res = Math.max(res, block.putBlock(i, j));

        System.out.println(res);
    }
}