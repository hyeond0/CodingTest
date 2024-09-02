import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, ans;
    static char[][] board;
    static int[][] distFire;
    static int[][] distJihoon;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        board = new char[R][C];
        distFire = new int[R][C];
        distJihoon = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }
    }

    static void pro() {
        bfs_fire();
        bfs_jihoon();
        if (ans == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans);
        }
    }

    static void bfs_fire() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                distFire[i][j] = -1;
                if (board[i][j] == 'F') {
                    Q.add(i);
                    Q.add(j);
                    distFire[i][j] = 0;
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (distFire[nx][ny] != -1) {
                    continue;
                }
                if (board[nx][ny] == '#') {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                distFire[nx][ny] = distFire[x][y] + 1;
            }
        }
    }

    static void bfs_jihoon() {
        ans = Integer.MAX_VALUE;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                distJihoon[i][j] = -1;
                if (board[i][j] == 'J') {
                    Q.add(i);
                    Q.add(j);
                    distJihoon[i][j] = 0;
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    ans = Math.min(distJihoon[x][y] + 1, ans);
                    return;
                }
                if (distJihoon[nx][ny] != -1) {
                    continue;
                }
                if (board[nx][ny] == '#') {
                    continue;
                }
                if (distFire[nx][ny] != -1 && distJihoon[x][y] + 1 >= distFire[nx][ny]) {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                distJihoon[nx][ny] = distJihoon[x][y] + 1;
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
