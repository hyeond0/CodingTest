import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t, w;
    static int[][][] d;
    static int[] a;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        t = scan.nextInt();
        w = scan.nextInt();
        d = new int[1005][35][3];

        for (int i = 1; i <= t; i++) {
            int tree = scan.nextInt();
            if (tree == 1) {
                d[i][0][1] = d[i - 1][0][1] + 1;
            } else {
                d[i][0][1] = d[i - 1][0][1];
            }

            for (int j = 1; j <= w; j++) {
                if (i < j) {
                    break;
                }
                if (tree == 1) {
                    d[i][j][1] = Math.max(d[i - 1][j][1], d[i - 1][j - 1][2]) + 1;
                    d[i][j][2] = Math.max(d[i - 1][j][2], d[i - 1][j - 1][1]);
                } else {
                    d[i][j][1] = Math.max(d[i - 1][j][1], d[i - 1][j - 1][2]);
                    d[i][j][2] = Math.max(d[i - 1][j][2], d[i - 1][j - 1][1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= w; i++) {
            ans = Math.max(ans, Math.max(d[t][i][1], d[t][i][2]));
        }
        System.out.println(ans);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
