import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] vis;
    static int[][] board;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        board = new int[n][m];
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        int max = 0, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !vis[i][j]) {
                    count++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        sb.append(count).append('\n').append(max);
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        int count = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        count++;
        vis[x][y] = true;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] != 1) {
                    continue;
                }
                vis[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                count++;
            }
        }
        return count;
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
