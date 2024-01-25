// Subject: Study of Algorithm with SSAFY
// ProblemNo: 12015
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 100001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, x, idx;
    static ArrayList<Integer> v = new ArrayList<>();

    static int custom_lower_bound(int tar){
        int lo = 0, hi = v.size() - 1;
        int ret = v.size();
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(tar <= v.get(mid)){
                ret = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ret;
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            x = Integer.parseInt(st.nextToken());
            idx = custom_lower_bound(x);
            if(idx == v.size()) v.add(x);
            else v.set(idx, x);
        }
        System.out.println(v.size());
    }

    //Reference Note
    public void myReferences() throws Exception{
        //[sysio] always throws Exception!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        System.out.println("");
        
        //[Map]
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //put(<T>)  get(<T>[0])  containsKey(<T>[0])  remove(<T>[0])  size()
        
        //[Priority Queue]
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //lower first
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); //higher first
        PriorityQueue<int[]> pq3 = new PriorityQueue<>((o1, o2)-> o1[0] - o2[0]); //lambda
        //add(<T>)  poll(<T>)=><T>:null  remove(<T>)=>void:exception  peak(<T>)=><T>:null (no remove)  element(<T>)=><T>:exception  clear()
        // @Override
        // public int compareTo(Gillog gillog) {
        //     if (this.writeRowNumber > gillog.getWriteRowNumber()) return 1;
        //     else if (this.writeRowNumber < gillog.getWriteRowNumber()) return -1;
        //     return 0; }

        //[ArrayList]
        ArrayList<Integer>[] list = new ArrayList[10];
        for (int i = 0; i < 10; i++) list[i] = new ArrayList<>();
		//add(<T>), get(idx)=><T>, set(idx, <T>)
		
        //[Mathematic Symbols]
        int M = Math.max(1, 2);
        
        //[string]
        //charAt(idx)
        
        //[Queue] add/offer remove/poll element/pick clear
        Queue<Integer> queue = new LinkedList<>();
        
    }

}