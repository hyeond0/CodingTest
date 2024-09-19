import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[] d;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        d = new int[12];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= 11; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }
        int T = scan.nextInt();
        while (T-- > 0) {
            n = scan.nextInt();
            sb.append(d[n]).append('\n');
        }
        System.out.println(sb.toString());
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
