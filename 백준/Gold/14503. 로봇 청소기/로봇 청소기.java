import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, c, d, ans;
    static int[][] board;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(ans);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        r = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scan.nextInt();
            }
        }
    }

    static void pro() {
        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = 2;
                ans++;
            }
            boolean isCleaning = true;
            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                if (board[nr][nc] != 0) {
                    continue;
                }
                isCleaning = false;
                break;
            }
            if (isCleaning) {
                int nr = r - dir[d][0];
                int nc = c - dir[d][1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    return;
                }
                if (board[nr][nc] == 1) {
                    return;
                }
                r = nr;
                c = nc;
            } else {
                while (true) {
                    if (d == 0) {
                        d = 3;
                    } else {
                        d -= 1;
                    }
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];
                    if (board[nr][nc] == 0) {
                        r = nr;
                        c = nc;
                        break;
                    }
                }
            }
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
