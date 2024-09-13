import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, empty_count, ans;
    static int[][] board, board2;
    static boolean[][] vis;
    static int[] selected;
    static Pair[] empty;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        rec_func(0, 0);
        System.out.println(ans);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        board = new int[n][m];
        board2 = new int[n][m];
        vis = new boolean[n][m];
        empty = new Pair[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = scan.nextInt();
                board[i][j] = num;
                if (num == 0) {
                    empty[empty_count++] = new Pair(i, j);
                }
            }
        }
        selected = new int[3];
        ans = Integer.MIN_VALUE;
    }

    static void rec_func(int k, int st) {
        if (k == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board[i][j];
                }
            }
            for (int i = 0; i < 3; i++) {
                Pair pair = empty[selected[i]];
                board2[pair.x][pair.y] = 1;
            }
            ans = Math.max(ans, bfs());
            return;
        }
        for (int i = st; i < empty_count; i++) {
            selected[k] = i;
            rec_func(k + 1, i + 1);
        }
    }

    static int bfs() {
        Queue<Pair> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = false;
                if (board2[i][j] == 2) {
                    Q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        while (!Q.isEmpty()) {
            Pair pair = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = pair.x + dir[k][0];
                int ny = pair.y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (board2[nx][ny] == 1) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                Q.add(new Pair(nx, ny));
                board2[nx][ny] = 2;
                vis[nx][ny] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board2[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
