import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board, board2;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        board = new int[n][n];
        board2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        int mx = 0;
        for (int tmp = 0; tmp < 1024; tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board2[i][j] = board[i][j];
                }
            }
            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mx = Math.max(mx, board2[i][j]);
                }
            }
        }
        System.out.println(mx);
    }

    static void rotate() {
        int[][] tmp = new int[21][21];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = board2[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board2[i][j] = tmp[n - 1 - j][i];
            }
        }
    }

    static void tilt(int dir) {
        while (dir-- > 0) {
            rotate();
        }
        for (int i = 0; i < n; i++) {
            int[] tilted = new int[21];
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if (board2[i][j] == 0) {
                    continue;
                }
                if (tilted[idx] == 0) {
                    tilted[idx] = board2[i][j];
                } else if (tilted[idx] == board2[i][j]) {
                    tilted[idx++] *= 2;
                } else {
                    tilted[++idx] = board2[i][j];
                }
            }
            for (int j = 0; j < n; j++) {
                board2[i][j] = tilted[j];
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
    }
}
