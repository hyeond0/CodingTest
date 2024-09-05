import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, minus_one, zero, one;
    static int[][] board;
    static int[] cnt = new int[3];
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        N = scan.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        rec_func(0, 0, N);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }

    static boolean check(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (board[r][c] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    static void rec_func(int r, int c, int n) {
        if (check(r, c, n)) {
            cnt[board[r][c] + 1]++;
            return;
        }
        int newN = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rec_func(r + i * newN, c + j * newN, newN);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
