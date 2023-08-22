import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    private static void input() {
        Scanner scan = new Scanner(System.in);
        N  = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
    }

    private static void pro() {
        visit = new boolean[N+1];
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            bfs(i);
            ans++;
        }
        System.out.println(ans);
    }

    private static void bfs(int x) {
        Queue<Integer> Q = new LinkedList<>();
        visit[x] = true;
        Q.add(x);

        while (!Q.isEmpty()) {
            x = Q.poll();
            for (int y : adj[x]) {
                if (visit[y]) continue;
                Q.add(y);
                visit[y] = true;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}