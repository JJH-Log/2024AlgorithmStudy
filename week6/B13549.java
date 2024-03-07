// Subject: Study of Algorithm with SSAFY
// ProblemNo: B13549
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static final int MX = 100101;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> queue[];
    static int N, K, vtd[], u[];

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        queue = new ArrayDeque[MX];
        for(int i = 0; i < MX; i++) queue[i] = new ArrayDeque();
        vtd = new int[MX];
        
        vtd[N] = 1;
        queue[1].offer(N);
        for(int i = 1; i < MX; i++){
            while(!queue[i].isEmpty()){
                int now = queue[i].poll();
                if(now == K) {
                    System.out.print(vtd[K] - 1);
                    return;
                }
                for(int t = 2; 0 < now && t * now < MX; t *= 2){
                    if(vtd[t * now] == 0){
                        vtd[t * now] = vtd[now];
                        queue[vtd[now]].offer(t * now);
                    }
                }
                if(now > 0 && vtd[now - 1] == 0){
                    vtd[now - 1] = vtd[now] + 1;
                    queue[vtd[now] + 1].offer(now - 1);
                }
                if(now < MX - 1 && vtd[now + 1] == 0){
                    vtd[now + 1] = vtd[now] + 1;
                    queue[vtd[now] + 1].offer(now + 1);
                }
            }
        }
        
    }
}