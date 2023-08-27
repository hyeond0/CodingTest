import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        dist = new int[N+1];
    }

    private static void bfs(int x) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);

        while (!Q.isEmpty()) {
            x = Q.poll();
            for (int y : adj[x]) {
                if (dist[y] != 0) continue;
                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    private static void pro() {
        bfs(1);
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (dist[i] == 1 || dist[i] == 2) count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}