import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] a;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        s = scan.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
    }

    static void pro() {
        int tot = a[0];
        int en = 0;
        int mn = Integer.MAX_VALUE;

        for (int st = 0; st < n; st++) {
            while (en < n && tot < s) {
                en++;
                if (en != n) {
                    tot += a[en];
                }
            }
            if (en == n) {
                break;
            }
            mn = Math.min(mn, en - st + 1);
            tot -= a[st];
        }

        if (mn == Integer.MAX_VALUE) {
            mn = 0;
        }

        System.out.println(mn);
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
