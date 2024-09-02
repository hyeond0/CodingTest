import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] board;
    static boolean[][] vis;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();
        board = new int[N][M];
        vis = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            int x1 = scan.nextInt(), y1 = scan.nextInt(), x2 = scan.nextInt(), y2 = scan.nextInt();
            if (x1 > x2) {
                int tmp = x2;
                x2 = x1;
                x1 = tmp;
            }
            if (y1 > y2) {
                int tmp = y2;
                y2 = y1;
                y1 = tmp;
            }

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    board[j][k] = 1;
                }
            }
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                vis[i][j] = false;
            }
        }
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 1 && !vis[i][j]) {
                    counts.add(bfs(i, j));
                }
            }
        }
        sb.append(counts.size()).append('\n');
        Collections.sort(counts);
        for (int count : counts) {
            sb.append(count).append(' ');
        }
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        int count = 0;
        Q.add(x);
        Q.add(y);
        vis[x][y] = true;
        count++;
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (vis[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                vis[nx][ny] = true;
                count++;
            }
        }
        return count;
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
