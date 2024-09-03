import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] board_melt;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        board = new int[N][M];
        board_melt = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        visit = new boolean[N][M];
    }

    static void pro() {
        copy_arr(board, board_melt);
        int year = 1;
        while (true) {
            melting();
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visit[i][j] = false;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visit[i][j] && board_melt[i][j] > 0) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            if (count > 1) {
                System.out.println(year);
                break;
            } else if (count == 0) {
                System.out.println(0);
                break;
            }
            year++;
            copy_arr(board_melt, board);
        }
    }

    static void melting() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0) {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (x < 0 || y < 0 || x >= N || y >= M) {
                            continue;
                        }
                        if (board[x][y] == 0) {
                            count++;
                        }
                    }
                    board_melt[i][j] = Math.max(board[i][j] - count, 0);
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        visit[x][y] = true;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                if (board_melt[nx][ny] == 0) {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }

    static void copy_arr(int[][] origin, int[][] target) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                target[i][j] = origin[i][j];
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
    }
}
