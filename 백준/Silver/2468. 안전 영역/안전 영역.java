import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, min, max, ans;
    static int[][] board;
    static boolean[][] vis;
    static FastReader scan = new FastReader();
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        board = new int[N][N];
        vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = scan.nextInt();
                max = Math.max(num, max);
                min = Math.min(num, min);
                board[i][j] = num;
            }
        }
    }

    static void pro() {
        for (int h = min; h < max; h++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    vis[i][j] = false;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!vis[i][j] && board[i][j] > h) {
                        count++;
                        bfs(i, j, h);
                    }
                }
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }

    static void bfs(int x, int y, int h) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        vis[x][y] = true;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] <= h) {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                vis[nx][ny] = true;
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
