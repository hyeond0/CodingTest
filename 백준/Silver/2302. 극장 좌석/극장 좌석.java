import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] d;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        d = new int[45];
        int[] vips = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            vips[i] = scan.nextInt();
        }
        d[1] = 1;
        d[2] = 2;
        for (int j = 1; j <= m; j++) {
            if (vips[j] == 2 || vips[j] == 1) {
                d[2] = 1;
                break;
            }
        }

        for (int i = 3; i <= n; i++) {
            boolean isVip = false;
            for (int j = 1; j <= m; j++) {
                if (i == vips[j] || i - 1 == vips[j]) {
                    isVip = true;
                    break;
                }
            }
            if (isVip) {
                d[i] = d[i - 1];
            } else {
                d[i] = d[i - 1] + d[i - 2];
            }
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
