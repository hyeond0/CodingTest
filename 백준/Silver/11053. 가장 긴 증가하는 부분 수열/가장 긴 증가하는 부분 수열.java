import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] d;
    static int[] a;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        a = new int[1001];
        d = new int[1001];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (a[i] > a[j]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }

        int max = 0;
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
