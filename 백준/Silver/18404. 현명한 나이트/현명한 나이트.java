import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, knightX, knightY;
    static int[][] dist;
    static int[][] dir = {{-2, 1}, {-2, -1}, {-1, -2}, {-1,2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> enemyQ = new LinkedList<>();

    private static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        knightX = scan.nextInt() - 1;
        knightY = scan.nextInt() - 1;
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
            }
        }
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt() - 1, y = scan.nextInt() - 1;
            enemyQ.add(x);
            enemyQ.add(y);
        }
    }

    private static void pro() {

        bfs(knightX, knightY);

        for (int i = 0; i < M; i++) {
            int x = enemyQ.poll();
            int y = enemyQ.poll();
            sb.append(dist[x][y]).append(' ');
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 0;
        int count = M;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (dist[nx][ny] != -1) continue;
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
