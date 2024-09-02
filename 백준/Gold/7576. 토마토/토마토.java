import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] dist;
    static int[][] board;
    static FastReader scan = new FastReader();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        m = scan.nextInt();
        n = scan.nextInt();
        board = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        bfs();

        boolean isValid = true;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1 && board[i][j] == 0) {
                    isValid = false;
                    break;
                }
                max = Math.max(max, dist[i][j]);
            }
        }

        if (isValid) {
            System.out.println(max);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
                if (board[i][j] == 1) {
                    dist[i][j] = 0;
                    Q.add(i);
                    Q.add(j);
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                if (board[nx][ny] == -1) {
                    continue;
                }
                dist[nx][ny] = dist[x][y] + 1;
                Q.add(nx);
                Q.add(ny);
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
