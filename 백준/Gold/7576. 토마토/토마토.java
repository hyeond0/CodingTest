import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map, dist;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        map = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    visit[i][j] = true;
                    dist[i][j] = 0;
                    Q.add(i);
                    Q.add(j);
                }
            }
        }

        while(!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] != 0) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    private static void pro() {
        // dist 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }
        // bfs 탐색
        bfs();

        // 탐색이 끝났는데 map 중 0이 있다면 -1 출력
        // 없다면 dist의 max 출력
        boolean isRipe = true;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] == -1 && map[i][j] == 0) isRipe = false;
                max = Math.max(dist[i][j], max);
            }
        }
        if (!isRipe) System.out.println(-1);
        else System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}