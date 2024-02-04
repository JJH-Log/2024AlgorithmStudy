// Subject: Study of Algorithm with SSAFY
// ProblemNo: 12865
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 2000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, x, y, v[], dp[][];

    static int solve(int l, int r){
        if(dp[l][r] != -1) return dp[l][r];
        if(l == r) return dp[l][r] = 1;
        if(r - l == 1) return dp[l][r] = v[l] == v[r]? 1 : 0;
        boolean FLAG = (v[l] == v[r] && solve(l + 1, r - 1) == 1);
        return dp[l][r] = FLAG? 1 : 0;
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new int[N];
        dp = new int[N][N];
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) dp[i][j] = -1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) v[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sb.append(solve(x - 1, y - 1)).append('\n');
        }
        System.out.print(sb.toString());
    }

    //Reference Note
    public void myReferences() throws Exception{
        //[sysio] Note: always throws Exception!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        System.out.println("");
        StringBuilder sb = new StringBuilder();
        sb.append("1").append(" ").append('\n');
		System.out.println(sb.toString());
		
        //[Map]
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //put(<T>)  get(<T>[0])  containsKey(<T>[0])  remove(<T>[0])  size()
        
        //[Priority Queue]
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //lower first
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); //higher first
        PriorityQueue<int[]> pq3 = new PriorityQueue<>((o1, o2)-> o1[0] - o2[0]); //lambda
        //add(<T>)  poll(<T>)=><T>:null  remove(<T>)=>void:exception  peak(<T>)=><T>:null (no remove)  element(<T>)=><T>:exception  clear()
        //@Override
        //public int compareTo(Gillog gillog) {
        //    if (this.writeRowNumber > gillog.getWriteRowNumber()) return 1;
        //    else if (this.writeRowNumber < gillog.getWriteRowNumber()) return -1;
        //    return 0; }

        //[ArrayList]
        ArrayList<Integer>[] list = new ArrayList[10];
        for (int i = 0; i < 10; i++) list[i] = new ArrayList<>();
		//add(<T>), get(idx)=><T>, set(idx, <T>)
		
        //[Mathematic Symbols]
        int M = Math.max(1, 2);
        
        //[string]
        //charAt(idx)
        
        //[Queue]
        Queue<Integer> queue = new LinkedList<>();
        //add/offer remove/poll element/pick clear
        
    }

}