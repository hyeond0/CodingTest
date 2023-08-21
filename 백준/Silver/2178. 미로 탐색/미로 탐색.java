import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int N, M;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] dist;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] m = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(m[j]);
            }
        }
    }


    static void bfs(int x, int y) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = 1;
            }
        }
        Queue<Integer> Que = new LinkedList<>();
        Que.add(x);
        Que.add(y); // 먼저 넣은게 x, 나중에 넣은 게 y
        visit[x][y] = true;

        while(!Que.isEmpty()) {
            x = Que.poll();
            y = Que.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;
                Que.add(nx);
                Que.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs(0,0);

        System.out.println(dist[N-1][M-1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}




