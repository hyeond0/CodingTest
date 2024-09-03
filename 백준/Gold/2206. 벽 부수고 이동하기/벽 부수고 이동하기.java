import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static FastReader scan = new FastReader();
    static char[][] board;
    static int[][][] dist;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        board = new char[N][M];
        dist = new int[2][N][M];
        for (int i = 0; i < N; i++) {
            String s = scan.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }
    }

    static void pro() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }
        bfs();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            if (dist[i][N - 1][M - 1] != -1) {
                min = Math.min(min, dist[i][N - 1][M - 1]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        Q.add(0);
        Q.add(0);
        dist[0][0][0] = 1;

        while (!Q.isEmpty()) {
            int wall = Q.poll();
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (dist[wall][nx][ny] != -1) {
                    continue;
                }
                if (board[nx][ny] == '1') {
                    if (wall == 0) {
                        dist[wall + 1][nx][ny] = dist[wall][x][y] + 1;
                        Q.add(wall + 1);
                        Q.add(nx);
                        Q.add(ny);
                    }
                } else {
                    Q.add(wall);
                    Q.add(nx);
                    Q.add(ny);
                    dist[wall][nx][ny] = dist[wall][x][y] + 1;
                }
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
