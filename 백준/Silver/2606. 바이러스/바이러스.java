import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, count;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    private static void input() throws IOException {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        visit = new boolean[N + 1];
        // adj 초기화
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    private static void bfs(int x) {
        Queue<Integer> Q = new LinkedList<>();
        visit[x] = true;
        Q.add(x);

        while(!Q.isEmpty()) {
            x = Q.poll();
            for (int y : adj[x]) {
                if (visit[y]) continue;
                Q.add(y);
                visit[y] = true;
                count++;
            }
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        count++;
        for (int y : adj[x]) {
            if (visit[y]) continue;
            dfs(y);
        }
    }


    private static void pro() {
        bfs(1);

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();

    }
}