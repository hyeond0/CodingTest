import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] map;
    static boolean[][] visit;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N][M];
    }
    private static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 0) {
                    if (map[x][y] > 0) {
                        map[x][y]--;
                    }
                }
            }
        }
    }

    static int bfsCount() {
        int ans = 0;
        boolean[][] check = new boolean[N][M];
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !check[i][j]) {
                    Q.add(i);
                    Q.add(j);

                    while (!Q.isEmpty()) {
                        int x = Q.poll();
                        int y = Q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dir[k][0];
                            int ny = y + dir[k][1];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (check[nx][ny]) continue;
                            if (map[nx][ny] == 0) continue;
                            Q.add(nx);
                            Q.add(ny);
                            check[nx][ny] = true;
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    static void pro() {
        int year = 0;
        while (true) {
            if (bfsCount() == 0) {
                year = 0;
                break;
            }
            if (bfsCount() >= 2)
                break;
            bfs();
            year++;
        }
        System.out.println(year);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}