import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] d, a;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        a = new int[100001];
        d = new int[100001];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        d[1] = a[1];
        for (int i = 2; i <= 100000; i++) {
            d[i] = Math.max(0, d[i - 1]) + a[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(d[i], max);
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
