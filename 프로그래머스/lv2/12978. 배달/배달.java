import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<Edge>[] edges = new ArrayList[N+1];
        int answer = 0;
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int weight = road[i][2];
            edges[a].add(new Edge(b, weight));
            edges[b].add(new Edge(a, weight));
        }
        
        int[] dist = dijkstra(1, N, edges);
        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i]);
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
    public int[] dijkstra(int start, int N, ArrayList<Edge>[] edges) {
        int[] dist = new int[N+1];
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
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
        
        return dist;
    }
    
    
    class Edge {
        public int to, weight;
        public Edge (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    class Info {
        public int idx, dist;
        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}