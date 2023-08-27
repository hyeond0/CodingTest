import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, p1, p2;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        p1 = scan.nextInt();
        p2 = scan.nextInt();
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        M = scan.nextInt();
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        dist[start] = 0;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int y : adj[x]) {
                if (dist[y] != -1) continue;
                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    private static void pro() {
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }
        bfs(p1);
        System.out.println(dist[p2]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
