import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static boolean isCrush;
    static char[][] board = new char[12][6];
    static boolean[][] vis = new boolean[12][6];
    static FastReader scan = new FastReader();
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(ans);
    }

    static void input() {
        for (int i = 0; i < 12; i++) {
            String s = scan.next();
            for (int j = 0; j < 6; j++) {
                board[i][j] = s.charAt(j);
            }
        }
    }

    static void pro() {
        while (true) {
            init_vis();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!vis[i][j] && board[i][j] != '.') {
                        bfs(i, j);
                    }
                }
            }
            if (isCrush) {
                ans++;
                update_map();
                isCrush = false;
            } else {
                break;
            }
        }
    }

    static void update_map() {
        for (int j = 0; j < 6; j++) {
            char[] tmp = new char[12];
            for (int i = 0; i < 12; i++) {
                tmp[i] = '.';
            }
            int idx = 11;
            for (int i = 11; i >= 0; i--) {
                if (board[i][j] != '.') {
                    tmp[idx--] = board[i][j];
                }
            }

            for (int i = 0; i < 12; i++) {
                board[i][j] = tmp[i];
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Pair> Q = new LinkedList<>();
        Stack<Pair> stack = new Stack<>();
        Q.add(new Pair(x, y));
        stack.add(new Pair(x, y));
        vis[x][y] = true;
        int count = 1;
        char color = board[x][y];

        while (!Q.isEmpty()) {
            Pair pair = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = pair.x + dir[k][0];
                int ny = pair.y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] != color) {
                    continue;
                }
                Pair nPair = new Pair(nx, ny);
                Q.add(nPair);
                stack.add(nPair);
                vis[nx][ny] = true;
                count++;
            }
        }

        if (count >= 4) {
            isCrush = true;
            while (!stack.isEmpty()) {
                Pair pair = stack.pop();
                board[pair.x][pair.y] = '.';
            }
        }
    }

    static void init_vis() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                vis[i][j] = false;
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
    }
}
