import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, H;
    static int[][][] dist;
    static int[][][] map;
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, -1}};

    private static void input() {
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        dist = new int[H][N][M];
        map = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = scan.nextInt();
                }
            }
        }
    }

    private static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (dist[i][j][k] == -1 && map[i][j][k] == 1) {
                        // 방문x 익은 토마토
                        Q.add(i);
                        Q.add(j);
                        Q.add(k);
                        dist[i][j][k] = 1;
                    }
                }
            }
        }

        while (!Q.isEmpty()) {
            int h = Q.poll();
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 6; k++) {
                int nh = h + dir[k][0];
                int nx = x + dir[k][1];
                int ny = y + dir[k][2];
                if (nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= N || ny >= M) continue;
                if (dist[nh][nx][ny] != -1) continue;
                if (map[nh][nx][ny] == -1) continue;
                Q.add(nh);
                Q.add(nx);
                Q.add(ny);
                dist[nh][nx][ny] = dist[h][x][y] + 1;
            }
        }
    }

    private static void pro() {
        // dist 초기화 및 모두 익었는지 체크
        boolean tomato = false;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) tomato = true;
                    dist[i][j][k] = -1;
                }
            }
        }
        if (!tomato) {
            System.out.println(0);
            return;
        }

        bfs();
        // 최소 기간
        boolean isRipe = true;
        int max = Integer.MIN_VALUE;
        int ripeCount = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0 && dist[i][j][k] == -1) isRipe = false;
                    if (dist[i][j][k] > max) max = dist[i][j][k];
                }
            }
            if (isRipe) ripeCount++;
        }
        if (ripeCount == H) System.out.println(max-1);
        else System.out.println(-1);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
