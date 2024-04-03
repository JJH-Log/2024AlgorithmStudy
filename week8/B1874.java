// Subject: Study of Algorithm with SSAFY
// ProblemNo: B1874
// Language: JAVA
// Author: pasta (JungJonghwa)
import java.io.*;
import java.util.*;

public class Main {

    static boolean check(){
        int ptr = 1;
        ArrayDeque<Integer> stack = new ArrayDeque();
        
        for(int i = 0; i < N; i++){
            while(ptr <= v[i]) {
                stack.push(ptr++);
                sb.append("+\n");
            }
            if(stack.isEmpty() || stack.peek() != v[i]) return false;
            stack.pop();
            sb.append("-\n");
        }
        return true;
    }
    
	static final int MX = 10000;
	static final int BOUND = 10000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, v[];
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        v = new int[N];

        for(int i = 0; i < N; i++)
        v[i] = Integer.parseInt(br.readLine());
        
        if(!check()) System.out.print("NO");
        else System.out.print(sb);
    }
}

//Reference Note
class References{
    static public void myReferences() throws Exception {
        //HashMap | put, get, containsKey, remove, size
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //HashSet | contains
        HashSet<String> animals3 = new HashSet<>(10);
        //Priority Queue | add, poll, remove, peak, element, clear
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //lower first
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); //higher first
        PriorityQueue<int[]> pq3 = new PriorityQueue<>((o1, o2)-> o1[0] - o2[0]); //lambda, minimal top
        //PriorityQueue<Info> pq4 = new PriorityQueue<Info>(Comparator.comparing(o->o.dist));
        /*
        //sort | Comparable
        class Refer implements Comparable{
            @Override
            public int compareTo(Refer refer) { }
        } //->Arrays.sort(myArrays)
        //sort | Comparator
        Comparator<Refer> comparator = new Comparator<Refer>() {
            @Override
            public int compare(Refer a, Refer b) {}
        }; //->Collections.sort(myArrays, comparator);
        //sort | lambda
        //myArrays.sort((s1,s2)->s1.getCodingLevel()-s2.getCodingLevel());
        */
        //ArrayList | add, get
        ArrayList<Integer>[] list = new ArrayList[10];
        for (int i = 0; i < 10; i++) list[i] = new ArrayList<>();
        //Mathematic Symbols | Math.max, Math.min...
        //Input, Output | always throws Exception!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); Integer.parseInt(st.nextToken());
        //String Operations | charAt, equals, substring, indexOf(=find)
        //Stack<Integer> stack = new Stack<>(); <-this is stack but slow
        //Queue<Integer> queue = new LinkedList<>() <- this is queue but slow
        //[Stack, Queue->Deque 써라] add/offer remove/poll element/pick clear addLast removeFirst removeLast getFirst getLast
        //Stack - push(), pop(), peek(), isEmpty()
        Deque<Integer> stack = new ArrayDeque<>();
        //Queue - offer(), poll(), peek(), isEmpty()
        Deque<Integer> queue = new ArrayDeque<>();
        //System.arraycopy( A, sourcePos, B, destPos, len );
    }
    //https://stackoverflow.com/questions/62786114/is-there-a-next-permutation-in-java
    static boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a){
            if (p[a] < p[a + 1]) {
                for (int b = p.length - 1;; --b) {
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }    
}
