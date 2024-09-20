import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] d, tri;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        d = new int[501][501];
        tri = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                tri[i][i - j + 1] = scan.nextInt();
            }
        }

        d[1][0] = tri[1][1];
        d[1][1] = tri[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]) + tri[i][j];
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(d[n][i], max);
        }
        System.out.println(max);
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

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
