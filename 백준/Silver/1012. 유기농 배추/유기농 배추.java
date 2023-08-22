import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, T, count;

    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> worm = new ArrayList<>();
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            pro();
        }
        for (int w : worm) sb.append(w).append('\n');
        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        visit[x][y] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        worm.add(count);
        count = 0;
    }
}