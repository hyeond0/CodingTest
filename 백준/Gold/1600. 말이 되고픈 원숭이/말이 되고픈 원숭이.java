import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k, w, h;
    static FastReader scan = new FastReader();
    static int[][] board;
    static int[][][] vis;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int[][] jump = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};


    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        k = scan.nextInt();
        w = scan.nextInt();
        h = scan.nextInt();
        board = new int[h][w];
        vis = new int[k + 1][h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < h; j++) {
                for (int l = 0; l < w; l++) {
                    vis[i][j][l] = -1;
                }
            }
        }
        bfs(0, 0);
        int ans = Integer.MAX_VALUE;
        for (int t = 0; t <= k; t++) {
            if (vis[t][h - 1][w - 1] != -1) {
                ans = Math.min(ans, vis[t][h - 1][w - 1]);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        Q.add(x);
        Q.add(y);
        vis[0][x][y] = 0;
        while (!Q.isEmpty()) {
            int jmp = Q.poll();
            x = Q.poll();
            y = Q.poll();
            if (jmp < k) {
                for (int t = 0; t < 8; t++) {
                    int nx = x + jump[t][0];
                    int ny = y + jump[t][1];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        continue;
                    }
                    if (board[nx][ny] != 0) {
                        continue;
                    }
                    if (vis[jmp + 1][nx][ny] != -1) {
                        continue;
                    }
                    vis[jmp + 1][nx][ny] = vis[jmp][x][y] + 1;
                    Q.add(jmp + 1);
                    Q.add(nx);
                    Q.add(ny);
                }
            }
            for (int t = 0; t < 4; t++) {
                int nx = x + dir[t][0];
                int ny = y + dir[t][1];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }
                if (board[nx][ny] != 0) {
                    continue;
                }
                if (vis[jmp][nx][ny] != -1) {
                    continue;
                }
                vis[jmp][nx][ny] = vis[jmp][x][y] + 1;
                Q.add(jmp);
                Q.add(nx);
                Q.add(ny);
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
