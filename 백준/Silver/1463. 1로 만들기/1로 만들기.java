import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[] dist;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        dist = new int[1000001];
        Arrays.fill(dist, -1);
        bfs(n);
        System.out.println(dist[1]);
    }

    static void bfs(int x) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        dist[x] = 0;

        while (!Q.isEmpty()) {
            x = Q.poll();
            if (x % 3 == 0) {
                if (dist[x / 3] == -1) {
                    Q.add(x / 3);
                    dist[x / 3] = dist[x] + 1;
                } else {
                    dist[x / 3] = Math.min(dist[x / 3], dist[x] + 1);
                }
            }
            if (x % 2 == 0) {
                if (dist[x / 2] == -1) {
                    Q.add(x / 2);
                    dist[x / 2] = dist[x] + 1;
                } else {
                    dist[x / 2] = Math.min(dist[x / 2], dist[x] + 1);
                }
            }
            if (x > 1) {
                if (dist[x - 1] == -1) {
                    Q.add(x - 1);
                    dist[x - 1] = dist[x] + 1;
                } else {
                    dist[x - 1] = Math.min(dist[x - 1], dist[x] + 1);
                }
            }
        }
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
