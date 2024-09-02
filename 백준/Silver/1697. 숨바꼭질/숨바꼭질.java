import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] board;
    static int[] dist;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        board = new int[100001];
        dist = new int[100001];
    }

    static void pro() {
        bfs(N);
        System.out.println(dist[K]);
    }

    static void bfs(int x) {
        for (int i = 0; i <= 100000; i++) {
            dist[i] = -1;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        dist[x] = 0;
        while (!Q.isEmpty()) {
            x = Q.poll();
            if (dist_check(x - 1)) {
                Q.add(x - 1);
                if (dist[x - 1] == -1) {
                    dist[x - 1] = dist[x] + 1;
                } else {
                    dist[x - 1] = Math.min(dist[x - 1], dist[x] + 1);
                }
                if (x - 1 == K) {
                    return;
                }
            }

            if (dist_check(x + 1)) {
                Q.add(x + 1);
                if (dist[x + 1] == -1) {
                    dist[x + 1] = dist[x] + 1;
                } else {
                    dist[x + 1] = Math.min(dist[x + 1], dist[x] + 1);
                }
                if (x - 1 == K) {
                    return;
                }
            }

            if (dist_check(x * 2)) {
                Q.add(x * 2);
                if (dist[x * 2] == -1) {
                    dist[x * 2] = dist[x] + 1;
                } else {
                    dist[x * 2] = Math.min(dist[x * 2], dist[x] + 1);
                }
                if (x * 2 == K) {
                    return;
                }
            }
        }
    }

    static boolean dist_check(int nx) {
        if (nx < 0 || nx > 100000) {
            return false;
        }
        return dist[nx] == -1;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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

        int nextInt() {
            return Integer.parseInt(next());
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
    }
}
