import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            w = scan.nextInt();
            h = scan.nextInt();
            if (w == 0 && h == 0) break;
            input();
            pro();
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        visit[x][y] = true;
        Q.add(x);
        Q.add(y);
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }

    private static void pro() {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        sb.append(count).append('\n');
    }

    private static void input() {
        map = new int[h][w];
        visit = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }
}