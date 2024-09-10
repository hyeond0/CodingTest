import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] board, board_tmp;
    static int[] selected;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(ans);
    }

    static void input() {
        n = scan.nextInt();
        board = new int[n][n];
        board_tmp = new int[n][n];
        selected = new int[5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
            }
        }
    }

    static void rec_func(int k) {
        if (k == 5) {
            // 0, 1, 2, 3 방향으로 5개를 뽑는다.
            // 0 남쪽, 1 서쪽, 2 북쪽, 3 동쪽
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board_tmp[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < 5; i++) {
                switch (selected[i]) {
                    case 0:
                        go_down();
                        break;
                    case 1:
                        go_left();
                        break;
                    case 2:
                        go_up();
                        break;
                    case 3:
                        go_right();
                        break;
                }
            }
            int value = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    value = Math.max(value, board_tmp[i][j]);
                }
            }
            ans = Math.max(ans, value);
            return;
        }
        for (int dir = 0; dir <= 3; dir++) {
            selected[k] = dir;
            rec_func(k + 1);
        }
    }

    static void go_left() {
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[21];
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if (board_tmp[i][j] > 0) {
                    if (tmp[idx] == 0) { // 해당 위치가 빈 칸이라면
                        tmp[idx] = board_tmp[i][j];
                    } else if (board_tmp[i][j] == tmp[idx]) { // 같은 값이라면
                        tmp[idx] += board_tmp[i][j];
                        idx++;
                    } else { // 다른 값이 있다면
                        tmp[++idx] = board_tmp[i][j];
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                board_tmp[i][j] = tmp[j];
            }
        }
    }

    static void go_right() {
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            int idx = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (board_tmp[i][j] > 0) {
                    if (tmp[idx] == 0) { // 해당 위치가 빈 칸이라면
                        tmp[idx] = board_tmp[i][j];
                    } else if (board_tmp[i][j] == tmp[idx]) { // 같은 값이라면
                        tmp[idx] += board_tmp[i][j];
                        idx--;
                    } else { // 다른 값이 있다면
                        tmp[--idx] = board_tmp[i][j];
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                board_tmp[i][j] = tmp[j];
            }
        }
    }

    static void go_up() {
        for (int j = 0; j < n; j++) {
            int[] tmp = new int[n];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (board_tmp[i][j] > 0) {
                    if (tmp[idx] == 0) { // 해당 위치가 빈 칸이라면
                        tmp[idx] = board_tmp[i][j];
                    } else if (board_tmp[i][j] == tmp[idx]) { // 같은 값이라면
                        tmp[idx] += board_tmp[i][j];
                        idx++;
                    } else { // 다른 값이 있다면
                        tmp[++idx] = board_tmp[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                board_tmp[i][j] = tmp[i];
            }
        }
    }

    static void go_down() {
        for (int j = 0; j < n; j++) {
            int[] tmp = new int[n];
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (board_tmp[i][j] > 0) {
                    if (tmp[idx] == 0) { // 해당 위치가 빈 칸이라면
                        tmp[idx] = board_tmp[i][j];
                    } else if (board_tmp[i][j] == tmp[idx]) { // 같은 값이라면
                        tmp[idx] += board_tmp[i][j];
                        idx--;
                    } else { // 다른 값이 있다면
                        tmp[--idx] = board_tmp[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                board_tmp[i][j] = tmp[i];
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
