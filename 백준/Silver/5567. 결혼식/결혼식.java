import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
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

    static void bfs(int start) {
        // dist 초기화
        for (int i = 1; i <= N; i++) {
            dist[i] = -1;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        dist[start] = 0;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int y : adj[x]) {
                if (dist[y] != -1) {
                    continue;
                }
                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }


    static void pro() {
        dist = new int[N + 1];
        int ans = 0;
        bfs(1);
        for (int i = 1; i <= N; i++) {
            if (dist[i] > 0 && dist[i] <= 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
