import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static boolean isEnd;
    static char[][][] board;
    static int[][][] dist;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) {
        while (!isEnd) {
            input();
            if (isEnd) {
                break;
            }
            pro();
        }
        System.out.println(sb);
    }

    static void input() {
        L = scan.nextInt();
        R = scan.nextInt();
        C = scan.nextInt();
        if (L == 0 && R == 0 && C == 0) {
            isEnd = true;
            return;
        }
        board = new char[L][R][C];
        dist = new int[L][R][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String s = scan.nextLine();
                for (int k = 0; k < C; k++) {
                    board[i][j][k] = s.charAt(k);
                }
            }
            scan.nextLine();
        }
    }

    static void pro() {
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (dist[i][j][k] == -1 && board[i][j][k] == 'S') {
                        int time = bfs(i, j, k);
                        if (time == -1) {
                            sb.append("Trapped!");
                        } else {
                            sb.append("Escaped in ").append(time).append(" minute(s).");
                        }
                    }
                }
            }
        }
        sb.append('\n');
    }

    static int bfs(int z, int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(z);
        Q.add(x);
        Q.add(y);
        dist[z][x][y] = 0;

        while (!Q.isEmpty()) {
            z = Q.poll();
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 6; k++) {
                int nz = z + dir[k][0];
                int nx = x + dir[k][1];
                int ny = y + dir[k][2];
                if (nz < 0 || nx < 0 || ny < 0 || nz >= L || nx >= R || ny >= C) {
                    continue;
                }
                if (dist[nz][nx][ny] != -1) {
                    continue;
                }
                if (board[nz][nx][ny] == '#') {
                    continue;
                }
                Q.add(nz);
                Q.add(nx);
                Q.add(ny);
                dist[nz][nx][ny] = dist[z][x][y] + 1;
                if (board[nz][nx][ny] == 'E') {
                    return dist[nz][nx][ny];
                }
            }
        }
        return -1;
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
