import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static char[][] arr;
    static int[] selected;
    static boolean[] isUsed;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        N = 5;
        input();
        rec_func(0, 0);
        System.out.println(ans);
    }

    static void input() {
        arr = new char[N][N];
        isUsed = new boolean[25];
        selected = new int[7];
        for (int i = 0; i < N; i++) {
            String s = scan.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
    }

    static void rec_func(int k, int st) {
        if (k == 7) {
            checkDasom();
            return;
        }
        for (int i = st; i < 25; i++) {
            selected[k] = i;
            rec_func(k + 1, i + 1);
        }
    }

    static void checkDasom() {
        Queue<Integer> Q = new LinkedList<>();
        int dasom = 0, adj = 0;
        boolean[][] isp7 = new boolean[5][5];
        boolean[][] vis = new boolean[5][5];
        for (int i = 0; i < 7; i++) {
            int x = selected[i] / 5, y = selected[i] % 5;
            isp7[x][y] = true;
            if (Q.isEmpty()) {
                Q.add(x);
                Q.add(y);
                vis[x][y] = true;
            }
        }
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            adj++;
            dasom += arr[x][y] == 'S' ? 1 : 0;
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || vis[nx][ny] || !isp7[nx][ny]) {
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                vis[nx][ny] = true;
            }
        }
        if (adj >= 7 && dasom >= 4) {
            ans++;
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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
    }
}
