import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] d, p;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        p = new int[1005];
        d = new int[1005];
        for (int i = 1; i <= n; i++) {
            p[i] = scan.nextInt();
        }
        d[1] = p[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                d[i] = Math.max(d[i], d[j] + p[i - j]);
            }
            d[i] = Math.max(p[i], d[i]);
        }
        System.out.println(d[n]);
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
