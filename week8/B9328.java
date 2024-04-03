// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9328
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {
    
    static class Pos{
        int x, y, type;
        Pos(int ...a){
            this.x = a[0];
            this.y = a[1];
            this.type = a[2];
        }
    }
    
	static final int MX = 10000;
	static final int MOD = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Pos> key, doc, door;
    static String tmp;
    static int T, N, M, v[][], vtd[][], keyList[], res;
    static ArrayDeque<Pos> queue = new ArrayDeque();
    
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            v = new int[N + 2][M + 2]; vtd = new int[N + 2][M + 2];
            key = new ArrayList(); doc = new ArrayList(); door = new ArrayList();
            for(int i = 0; i < N; i++){
                tmp = br.readLine();
                for(int j = 0; j < M; j++) {
                    char c = tmp.charAt(j);
                    if(c >= 'A' && c <= 'Z') {
                        door.add(new Pos(i + 1, j + 1, c - 'A'));
                        v[i + 1][j + 1] = 1;
                    }
                    if(c >= 'a' && c <= 'z') key.add(new Pos(i + 1, j + 1, c - 'a'));
                    if(c == '*') v[i + 1][j + 1] = 1;
                    if(c == '$') doc.add(new Pos(i + 1, j + 1, 1));
                }
            }
            keyList = new int[26];
            tmp = br.readLine();
            for(int i = 0; i < tmp.length(); i++) if(tmp.charAt(i) >= 'a') keyList[tmp.charAt(i) - 'a']++;
            
            queue.offer(new Pos(0, 0, 0));
            vtd[0][0]++;
            
            while(!queue.isEmpty()){
                while(!queue.isEmpty()){
                    Pos now = queue.poll();
                    for(int i = 0; i < 4; i++){
                        int dx = now.x + "2011".charAt(i) - '1';
                        int dy = now.y + "1120".charAt(i) - '1';
                        if(dx >= 0 && dx < N + 2 && dy >= 0 && dy < M + 2 && v[dx][dy] == 0 && vtd[dx][dy] == 0){
                            vtd[dx][dy]++;
                            queue.offer(new Pos(dx, dy, 0));
                        }
                    }
                }
                for(Pos k : key) if(vtd[k.x][k.y] > 0 && k.type >= 0) { keyList[k.type]++; k.type = -1; }
                for(Pos d : doc) if(vtd[d.x][d.y] > 0 && d.type > 0) { d.type--; res++; }
                for(Pos d : door){
                    if(d.type >= 0 && keyList[d.type] > 0){
                        boolean FLAG = false;
                        for(int i = 0; i < 4; i++){
                            int dx = d.x + "2011".charAt(i) - '1';
                            int dy = d.y + "1120".charAt(i) - '1';
                            if(vtd[dx][dy] > 0) FLAG = true;
                        }
                        if(FLAG){
                            d.type = -1;
                            vtd[d.x][d.y]++;
                            queue.offer(new Pos(d.x, d.y, 0));
                        }
                    }
                }
            }
            sb.append(res + "\n");
            res = 0;
        }
        System.out.print(sb);
    }
}