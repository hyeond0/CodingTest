import java.util.*;
import java.io.*;
public class Main {
	static int N,M, start, end;
	static int[] dist;
	static ArrayList<Edge>[] edges;
	
	static class Edge {
		public int weight, to;
		public Edge(int _weight, int _to) {
			this.weight = _weight;
			this.to = _to;
		}
	}
	static class Info {
		public int idx, dist;
		public Info(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N+1];
		edges = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[from].add(new Edge(weight, to));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
	}
	
	static void dijkstra(int start) {
		for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
		pq.add(new Info(start, 0));
		dist[start] = 0;
		while (!pq.isEmpty()) {
			Info info = pq.poll();
			if (dist[info.idx] < info.dist) continue;
			
			for (Edge e : edges[info.idx]) {
				if (dist[info.idx] + e.weight >= dist[e.to]) continue;
				
				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}
	
	
	static void pro() {
		dijkstra(start);
		System.out.println(dist[end]);
	}
	
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}