import java.util.*;
import java.io.*;

public class Main {
    static int N, M, liveSheep, liveWolf, sheepCount, wolfCount;
    static String[] map;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    static boolean sheepWin;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }
    }

    private static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        sheepCount++;
        Q.add(x);
        Q.add(y);
        visit[x][y] = true;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (map[nx].charAt(ny) == '#') continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                if (map[nx].charAt(ny) == 'o') sheepCount++;
                else if (map[nx].charAt(ny) == 'v') wolfCount++;
            }
        }

        if (sheepCount > wolfCount) sheepWin = true;
        else sheepWin = false;
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i].charAt(j) == 'v') liveWolf++;
                else if (map[i].charAt(j) == 'o') {
                    liveSheep++;
                    if (!visit[i][j]) {
                        sheepCount = 0;
                        wolfCount = 0;
                        bfs(i, j);
                        if (sheepWin) liveWolf -= wolfCount;
                        else liveSheep -= sheepCount;
                    }
                }
            }
        }
        
        sb.append(liveSheep).append(' ').append(liveWolf);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}