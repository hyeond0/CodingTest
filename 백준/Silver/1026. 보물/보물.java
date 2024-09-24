import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a, b;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(a);
        int[] b_tmp = new int[n];
        for (int i = 0; i < n; i++) {
            b_tmp[i] = b[i];
        }
        Arrays.sort(b_tmp);
        int[] b_idx = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b_tmp[i] == b[j]) {
                    b_idx[i] = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (b[b_idx[i]] * a[n - 1 - i]);
        }
        System.out.println(ans);
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
