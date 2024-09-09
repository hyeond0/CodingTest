import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] board, tmp;
    static List<CCTV> cctvs;
    static FastReader scan = new FastReader();
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(ans);
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        board = new int[N][M];
        tmp = new int[N][M];
        cctvs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = scan.nextInt();
                board[i][j] = num;
                if (num >= 1 && num <= 5) {
                    cctvs.add(new CCTV(i, j));
                }
                if (board[i][j] == 0) {
                    ans++;
                }
            }
        }
    }

    static void pro() {
        int k = 4;
        for (int i = 0; i < cctvs.size(); i++) {
            k *= 4;
        }
        for (int t = 0; t < k - 1; t++) {
            copy_array();
            int brute = t;
            for (CCTV cctv : cctvs) {
                int d = brute % 4;
                brute /= 4;
                int x = cctv.x;
                int y = cctv.y;
                if (board[x][y] == 1) {
                    rotate(x, y, d);
                } else if (board[x][y] == 2) {
                    rotate(x, y, d);
                    rotate(x, y, d + 2);
                } else if (board[x][y] == 3) {
                    rotate(x, y, d);
                    rotate(x, y, d + 1);
                } else if (board[x][y] == 4) {
                    rotate(x, y, d);
                    rotate(x, y, d + 1);
                    rotate(x, y, d + 2);
                } else {
                    rotate(x, y, d);
                    rotate(x, y, d + 1);
                    rotate(x, y, d + 2);
                    rotate(x, y, d + 3);
                }
            }
            ans = Math.min(check_spot(), ans);
        }
    }

    static void rotate(int x, int y, int r) {
        r %= 4;
        while (true) {
            x += dir[r][0];
            y += dir[r][1];
            if (x < 0 || y < 0 || x >= N || y >= M) {
                return;
            }
            if (tmp[x][y] == 6) {
                return;
            }
            if (tmp[x][y] != 0) {
                continue;
            }
            tmp[x][y] = 7;
        }
    }

    static int check_spot() {
        int val = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) {
                    val++;
                }
            }
        }
        return val;
    }

    static void copy_array() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = board[i][j];
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

    static class CCTV {
        int x;
        int y;

        public CCTV(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
