import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h;
    static int[][][] dist;
    static int[][][] board;
    static FastReader scan = new FastReader();
    static int[][] dir = {{-1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        m = scan.nextInt();
        n = scan.nextInt();
        h = scan.nextInt();
        board = new int[n][m][h];
        dist = new int[n][m][h];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j][k] = scan.nextInt();
                }
            }
        }
    }

    static void pro() {
        bfs();
        boolean isValid = true;
        int max = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dist[i][j][k] == -1 && board[i][j][k] == 0) {
                        isValid = false;
                        break;
                    }
                    max = Math.max(max, dist[i][j][k]);
                }
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
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dist[i][j][k] = -1;
                    if (board[i][j][k] == 1) {
                        dist[i][j][k] = 0;
                        Q.add(i);
                        Q.add(j);
                        Q.add(k);
                    }
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            int z = Q.poll();
            for (int k = 0; k < 6; k++) {
                int nz = z + dir[k][0];
                int nx = x + dir[k][1];
                int ny = y + dir[k][2];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) {
                    continue;
                }
                if (dist[nx][ny][nz] != -1) {
                    continue;
                }
                if (board[nx][ny][nz] == -1) {
                    continue;
                }
                dist[nx][ny][nz] = dist[x][y][z] + 1;
                Q.add(nx);
                Q.add(ny);
                Q.add(nz);
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
