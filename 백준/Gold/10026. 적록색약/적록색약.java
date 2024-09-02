import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] board;
    static int[][] dist;
    static int[][] dist_RG;
    static FastReader scan = new FastReader();
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        board = new char[N][N];
        dist = new int[N][N];
        dist_RG = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
                dist_RG[i][j] = -1;
            }
        }
        int count = 0, rg_count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] == -1) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist_RG[i][j] == -1) {
                    bfs_rg(i, j);
                    rg_count++;
                }
            }
        }
        System.out.println(count + " " + rg_count);
    }

    static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 1;
        char color = board[x][y];
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                if (board[nx][ny] != color) {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void bfs_rg(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist_RG[x][y] = 1;
        char color = board[x][y];

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (dist_RG[nx][ny] != -1) {
                    continue;
                }
                if (color == 'R' || color == 'G') {
                    if (board[nx][ny] == 'B') {
                        continue;
                    }
                } else {
                    if (board[nx][ny] != 'B') {
                        continue;
                    }
                }
                Q.add(nx);
                Q.add(ny);
                dist_RG[nx][ny] = dist_RG[x][y] + 1;
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
