import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] dist;
    static FastScanner scan = new FastScanner();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        dist = new int[100001];
    }

    static void bfs(int start) {
        for (int i = 0; i <= 100000; i++) {
            dist[i] = -1;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        dist[start] = 0;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int minus = x - 1;
            if (minus >= 0) {
                if (dist[minus] == -1) {
                    dist[minus] = dist[x] + 1;
                    Q.add(minus);
                } else {
                    dist[minus] = Math.min(dist[x] + 1, dist[minus]);
                }
            }

            int plus = x + 1;
            if (plus >= 0 && plus <= 100000) {
                if (dist[plus] == -1) {
                    dist[plus] = dist[x] + 1;
                    Q.add(plus);
                } else {
                    dist[plus] = Math.min(dist[x] + 1, dist[plus]);
                }
            }

            int doubleX = x * 2;
            if (doubleX >= 0 && doubleX <= 100000) {
                if (dist[doubleX] == -1) {
                    dist[doubleX] = dist[x] + 1;
                    Q.add(doubleX);
                } else {
                    dist[doubleX] = Math.min(dist[x] + 1, dist[doubleX]);
                }
            }
        }
    }

    static void pro() {
        bfs(N);
        System.out.println(dist[K]);
    }


    static class FastScanner {
        StringTokenizer st;
        BufferedReader br;

        FastScanner() {
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
