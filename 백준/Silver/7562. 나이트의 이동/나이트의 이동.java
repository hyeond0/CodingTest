import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int I, start_x, start_y, end_x, end_y;
    static int[][] dist;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
    static FastScanner scan = new FastScanner();

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int i = 1; i <= T; i++) {
            input();
            pro();
        }
    }

    static void pro() {
        bfs(start_x, start_y);
        System.out.println(dist[end_x][end_y]);
    }

    static void bfs(int x, int y) {
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < I; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        dist[x][y] = 0;

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= I || ny >= I) {
                    continue;
                }
                if (dist[nx][ny] != -1) {
                    continue;
                }
                que.add(nx);
                que.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void input() {
        I = scan.nextInt();
        dist = new int[I][I];
        start_x = scan.nextInt();
        start_y = scan.nextInt();
        end_x = scan.nextInt();
        end_y = scan.nextInt();
    }

    static class FastScanner {
        StringTokenizer st;
        BufferedReader br;

        FastScanner() {
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
