import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int T, N, startX, startY, finishX, finishY;
    static int[][] dist;
    static int[][] dir = {{-2, 1}, {-2, -1}, {-1, -2}, {-1,2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    private static void input() {
        N = scan.nextInt();
        dist = new int[N][N];
        startX = scan.nextInt();
        startY = scan.nextInt();
        finishX = scan.nextInt();
        finishY = scan.nextInt();
    }

    private static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 0;
        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (dist[nx][ny] > 0) continue;
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
                if (nx == finishX && ny == finishY) break;
            }
        }
    }

    private static void pro() {
        //dist 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
            }
        }

        // map 중 시작점 탐색
        // bfs
        if (startX == finishX && startY == finishY) {
            sb.append(0).append('\n');
        } else {
            bfs(startX, startY);
            sb.append(dist[finishX][finishY]).append('\n');
        }
    }

    public static void main(String[] args) {
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
        System.out.println(sb.toString());
    }
}
