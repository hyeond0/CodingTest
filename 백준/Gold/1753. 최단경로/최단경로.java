
import java.util.*;
public class Main {
	static int V, E, start;
	static long[] dist;
	static ArrayList<Edge>[] edges;
	
	static class Info {
		public int idx;
		public long dist;
		
		public Info(int idx, long dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}
	static class Edge {
		public int to;
		public long weight;
		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		V = scan.nextInt();
		E = scan.nextInt();
		start = scan.nextInt();
		dist = new long[V+1];
		edges = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) edges[i] = new ArrayList<>();
		for (int i = 1; i <= E; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			long w = scan.nextLong();
			edges[u].add(new Edge(v, w));
		}
	}
	
	static void dijkstra(int start) {
		for (int i = 1; i <= V; i++) dist[i] = Long.MAX_VALUE;
		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
		pq.add(new Info(start, 0));
		dist[start] = 0;
		while (!pq.isEmpty()) {
			Info info = pq.poll();
			if (info.dist != dist[info.idx]) continue;
			for (Edge e : edges[info.idx]) {
				if (dist[info.idx] + e.weight >= dist[e.to]) continue;
				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
			}
		}
	}
	
	static void pro() {
		dijkstra(start);
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Long.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
	public static void main(String[] args) {
		input();
		pro();
	}
}