import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] d;
    static int[] a;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        a = new int[10005];
        d = new int[10005][3];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        d[1][1] = a[1];
        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
            d[i][1] = d[i - 1][0] + a[i];
            d[i][2] = d[i - 1][1] + a[i];
        }

        int ans = 0;
        int[] arr = {ans, d[n][0], d[n][1], d[n][2]};
        Arrays.sort(arr);
        ans = arr[3];
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
