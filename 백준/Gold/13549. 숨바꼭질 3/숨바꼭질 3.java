import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static FastReader scan = new FastReader();
    static int[] board, dist;
    static boolean[] vis;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        k = scan.nextInt();
        board = new int[200001];
        dist = new int[200001];
        vis = new boolean[200001];
    }

    static void pro() {
        for (int i = 0; i <= 200000; i++) {
            dist[i] = -1;
        }
        bfs(n);
        System.out.println(dist[k]);
    }

    static void bfs(int x) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        vis[x] = true;
        dist[x] = 0;

        while (!Q.isEmpty()) {
            x = Q.poll();
            for (int nx : new int[] {x * 2, x - 1, x + 1}) {
                if (nx < 0 || nx > 200000) {
                    continue;
                }
                if (vis[nx]) {
                    continue;
                }
                vis[nx] = true;
                if (nx == x * 2) {
                    if (dist[nx] == -1) {
                        dist[nx] = dist[x];
                    } else {
                        dist[nx] = Math.min(dist[nx], dist[x]);
                    }
                } else {
                    if (dist[nx] == -1) {
                        dist[nx] = dist[x] + 1;
                    } else {
                        dist[nx] = Math.min(dist[nx], dist[x] + 1);
                    }
                }
                Q.add(nx);
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
