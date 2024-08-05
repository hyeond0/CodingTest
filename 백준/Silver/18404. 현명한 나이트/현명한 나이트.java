import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X, Y;
    static int[][] dist;
    static List<Integer> x_list;
    static List<Integer> y_list;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static FastScanner scan = new FastScanner();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        X = scan.nextInt();
        Y = scan.nextInt();
        x_list = new ArrayList<>();
        y_list = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            x_list.add(scan.nextInt());
            y_list.add(scan.nextInt());
        }
        dist = new int[N + 1][N + 1];
    }

    static void bfs(int x, int y) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 0;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > N || ny > N) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs(X, Y);
        for (int i = 0; i < M; i++) {
            sb.append(dist[x_list.get(i)][y_list.get(i)]).append(' ');
        }
        System.out.println(sb);
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
