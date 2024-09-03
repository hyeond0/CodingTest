import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static FastReader scan = new FastReader();
    static int[][] board, dist;
    static boolean[][] vis;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        board = new int[N][N];
        dist = new int[N][N];
        vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        int number = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0 && !vis[i][j]) {
                    bfs(i, j, number++);
                }
            }
        }

        init_dist();
        ans = Integer.MAX_VALUE;
        bfs_dist();
        System.out.println(ans);
    }

    private static void init_dist() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
            }
        }
    }

    static void bfs_dist() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    Q.add(i);
                    Q.add(j);
                    dist[i][j] = 0;
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (board[nx][ny] == board[x][y]) {
                    continue;
                }
                if (board[nx][ny] != 0) {
                    ans = Math.min(ans, dist[nx][ny] + dist[x][y]);
                } else {
                    Q.add(nx);
                    Q.add(ny);
                    board[nx][ny] = board[x][y];
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
    }

    static void bfs(int x, int y, int number) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        board[x][y] = number;
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
                if (board[nx][ny] == 0) {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                board[nx][ny] = number;
                vis[nx][ny] = true;
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
