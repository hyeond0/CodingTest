import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visit;
    static int[][] adj;
    private static void input() {
        Scanner scan = new Scanner(System.in);
        N  = scan.nextInt();
        M = scan.nextInt();
        adj = new int[N+1][N+1];
        for (int i = 1; i <= M; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
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
            for (int y = 1; y <= N; y++) {
                if (visit[y]) continue;
                if (adj[x][y] == 0) continue;
                Q.add(y);
                visit[y] = true;
                adj[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}