// Subject: Study of Algorithm with SSAFY
// ProblemNo: 5719
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

class Edge{
    int tar, cost;
    Edge(int tar, int cost){
        this.tar = tar;
        this.cost = cost;
    }
}

public class Main {

    static final int MX = 100000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, S, D, x, y, d, dist[], res;
    static boolean vtd[], ban[][];
    static ArrayList<Edge>[] gph, rgph;
    static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost);
    static Queue<Integer> q = new LinkedList<>();
    
    static int dijkstra(int s, int e){
        dist = new int[N];
        for(int i = 0; i < N; i++) dist[i] = (int)1e9;
        dist[s] = 0;
        pq.add(new Edge(s, dist[s]));
        while(!pq.isEmpty()){
            Edge now = pq.remove(); 
            if(now.cost != dist[now.tar]) continue;
            for(Edge next : gph[now.tar]){
                if(ban[now.tar][next.tar]) continue;
                if(dist[next.tar] > now.cost + next.cost){
                    rgph[next.tar].clear(); rgph[next.tar].add(new Edge(now.tar, next.cost));
                    dist[next.tar] = now.cost + next.cost;
                    pq.add(new Edge(next.tar, dist[next.tar]));
                }
                else if(dist[next.tar] == now.cost + next.cost) rgph[next.tar].add(new Edge(now.tar, next.cost));
            }
        }
        return dist[e];
    }
    
    static void retrack(int e){
        vtd[e] = true; q.add(e);
        while(!q.isEmpty()){
            int now = q.remove();
            for(Edge next : rgph[now]){
                if(dist[now] == dist[next.tar] + next.cost) ban[next.tar][now] = true;
                if(vtd[next.tar]) continue;
                else{
                    vtd[next.tar] = true; q.add(next.tar);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            gph = new ArrayList[N];
            rgph = new ArrayList[N];
            for (int i = 0; i < N; i++) gph[i] = new ArrayList<>();
            for (int i = 0; i < N; i++) rgph[i] = new ArrayList<>();
            vtd = new boolean[N];
            ban = new boolean[N][N];
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                gph[x].add(new Edge(y, d));
            }
            dijkstra(S, D);
            retrack(D);
            res = dijkstra(S, D);
            System.out.println(res == (int)1e9? -1 : res);
        }
        
        
    }
}