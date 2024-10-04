import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, x, y;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            m = scan.nextInt();
            n = scan.nextInt();
            x = scan.nextInt();
            y = scan.nextInt();
            pro();
        }
        System.out.println(sb);
    }

    static void pro() {
        if (x == m) {
            x = 0;
        }
        if (y == n) {
            y = 0;
        }
        int l = lcm(m, n);
        for (int i = x; i <= l; i += m) {
            if (i == 0) {
                continue;
            }
            if (i % n == y) {
                sb.append(i).append('\n');
                return;
            }
        }
        sb.append(-1).append('\n');
    }

    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
