import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] a, b, c;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }

    static void pro() {
        int a_idx = 0;
        int b_idx = 0;
        for (int i = 0; i < n + m; i++) {
            if (a_idx >= n) {
                c[i] = b[b_idx++];
                continue;
            }
            if (b_idx >= m) {
                c[i] = a[a_idx++];
                continue;
            }
            if (a[a_idx] <= b[b_idx]) {
                c[i] = a[a_idx++];
            } else {
                c[i] = b[b_idx++];
            }
        }

        for (int i = 0; i < n + m; i++) {
            sb.append(c[i]).append(' ');
        }
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scan.nextInt();
        }
        c = new int[n + m];
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
