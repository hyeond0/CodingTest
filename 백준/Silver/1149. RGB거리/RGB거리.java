import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] d;
    static int[][] rgb;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        d = new int[n + 1][3];
        rgb = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            rgb[i][0] = scan.nextInt();
            rgb[i][1] = scan.nextInt();
            rgb[i][2] = scan.nextInt();
        }
        d[1][0] = rgb[1][0];
        d[1][1] = rgb[1][1];
        d[1][2] = rgb[1][2];
        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + rgb[i][0];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + rgb[i][1];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + rgb[i][2];
        }
        System.out.println(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));
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
