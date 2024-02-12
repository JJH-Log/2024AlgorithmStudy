import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Query{
	int x, y;
	Query(){}
	Query(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static final int MX = 50000;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> []gph, w;
	static int N, Q, x, y;
	static int []par, depth, vtd;
	static ArrayList<Query> q;
	
	static void bfs() {
		Queue<Query> _q = new ArrayDeque<>();
		vtd[0] = 1;
		_q.add(new Query(0, -1));
		while(!_q.isEmpty()) {
			Query now = _q.poll();
			
			if(now.y != -1) {
				depth[now.x] = depth[now.y] + 1;
				w[now.x].add(now.y);
				int idx = 0;
				for(int t = 1; t * 2 <= depth[now.x]; t *= 2, idx++) {
					w[now.x].add(w[w[now.x].get(idx)].get(idx));
				}
			}
			for(int tar : gph[now.x]){
				if(tar == now.y) continue;
				if(vtd[tar] == 0) {
					vtd[tar] = 1;
					_q.add(new Query(tar, now.x));
				}
			}
		}
	}
	
	static void dfs(int now, int parent) {
		if(parent != -1) {
			depth[now] = depth[parent] + 1;
			w[now].add(parent);
			int idx = 0;
			for(int t = 1; t * 2 <= depth[now]; t *= 2, idx++) {
				w[now].add(w[w[now].get(idx)].get(idx));
			}
		}
		for(int tar : gph[now]) {
			if(tar == parent) continue;
			dfs(tar, now);
		}
	}
	
	static int lca(int a, int b) {
		if(a == b) return a + 1;
		if(depth[a] > depth[b]) return lca(b, a);
		if(depth[a] < depth[b]) {
			int t = 1;
			int idx = 0;
			while(t <= depth[b] - depth[a]) { t *= 2; idx++; }
			return lca(a, w[b].get(idx - 1));
		}
		else {
			int idx = 0;
			while(idx < w[a].size() && (w[a].get(idx) != w[b].get(idx))) idx++;
			if(idx != 0) idx--;
			return lca(w[a].get(idx), w[b].get(idx));
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(bf.readLine());
		gph = new ArrayList[N];
		w = new ArrayList[N];
		for(int i = 0; i < N; i++) gph[i] = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) w[i] = new ArrayList<Integer>();
		par = new int[N];
		depth = new int[N];
		vtd = new int[N];
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			x = Integer.parseInt(st.nextToken()); x--;
			y = Integer.parseInt(st.nextToken()); y--;
			gph[x].add(y);
			gph[y].add(x);
		}
		
		Q = Integer.parseInt(bf.readLine());
		q = new ArrayList<Query>();
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(bf.readLine());
			x = Integer.parseInt(st.nextToken()); x--;
			y = Integer.parseInt(st.nextToken()); y--;
			Query tmp = new Query(x, y);
			q.add(tmp);
		}
		bfs();
		for(int i = 0; i < Q; i++) sb.append(lca(q.get(i).x, q.get(i).y)).append(" ").append('\n');
		System.out.println(sb.toString());
	}
}
