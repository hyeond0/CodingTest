import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] d, nums;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        d = new int[n + 1];
        d[1] = scan.nextInt();
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + scan.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int first = scan.nextInt();
            int second = scan.nextInt();
            sb.append(d[second] - d[first - 1]).append('\n');
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
    }
}
