import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] board;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        N = scan.nextInt();
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = scan.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        rec_func(0, 0, N);
        System.out.println(sb);
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


    static void rec_func(int x, int y, int n) {
        if (N == 1 || check(x, y, n)) {
            sb.append(board[x][y]);
        } else {
            sb.append('(');
            int newN = n / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    rec_func(x + i * newN, y + j * newN, newN);
                }
            }
            sb.append(')');
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
