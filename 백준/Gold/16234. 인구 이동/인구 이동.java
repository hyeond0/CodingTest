import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r, ans;
    static boolean move;
    static int[][] board, dist;
    static boolean[][] vis;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        l = scan.nextInt();
        r = scan.nextInt();
        board = new int[n][n];
        dist = new int[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
                dist[i][j] = -1;
            }
        }
    }

    static void pro() {
        int day = 0;
        int count = 0;
        while (true) {
            move = false;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (!vis[x][y]) {
                        bfs(x, y, count++);
                    }
                }
            }
            if (!move) {
                break;
            }
            day++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    vis[i][j] = false;
                    dist[i][j] = -1;
                }
            }
        }
        System.out.println(day);
    }

    static void bfs(int x, int y, int count) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = count;
        vis[x][y] = true;
        int sum = board[x][y];
        int cnt = 1;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                int population = Math.abs(board[nx][ny] - board[x][y]);
                if (population >= l && population <= r) {
                    move = true;
                    dist[nx][ny] = count;
                    vis[nx][ny] = true;
                    Q.add(nx);
                    Q.add(ny);
                    sum += board[nx][ny];
                    cnt++;
                }
            }
        }
        if (cnt > 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] == count) {
                        board[i][j] = sum / cnt;
                    }
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
