import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static int[] board;
    static int[] dist;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        F = scan.nextInt();
        S = scan.nextInt();
        G = scan.nextInt();
        U = scan.nextInt();
        D = scan.nextInt();
        board = new int[1000002];
        dist = new int[1000002];
    }

    static void pro() {
        for (int i = 0; i <= F; i++) {
            dist[i] = -1;
        }
        bfs(S);
        if (dist[G] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(dist[G]);
        }
    }

    static void bfs(int x) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        dist[x] = 0;

        while (!Q.isEmpty()) {
            x = Q.poll();
            for (int nx : new int[] {x + U, x - D}) {
                if (nx <= 0 || nx > F) {
                    continue;
                }
                if (dist[nx] != -1) {
                    continue;
                }
                dist[nx] = dist[x] + 1;
                Q.add(nx);
            }
        }
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
