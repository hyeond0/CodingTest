import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[][] d;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        d = new long[105][10];
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            for (int k = 0; k <= 9; k++) {
                if (k != 0) {
                    d[i][k] += d[i - 1][k - 1];
                }
                if (k != 9) {
                    d[i][k] += d[i - 1][k + 1];
                }
                d[i][k] %= 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += d[n][i];
        }
        sum %= 1000000000;
        System.out.println(sum);
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
