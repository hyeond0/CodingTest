import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] d;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        d = new long[101];
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;
        for (int i = 6; i <= 100; i++) {
            d[i] = d[i - 1] + d[i - 5];
        }
        int T = scan.nextInt();
        while (T-- > 0) {
            sb.append(d[scan.nextInt()]).append('\n');
        }
        System.out.println(sb);
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
