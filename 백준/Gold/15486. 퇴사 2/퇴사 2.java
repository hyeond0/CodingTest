import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] d;
    static Consult[] a;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        a = new Consult[1500010];
        d = new int[1500010];
        for (int i = 1; i <= n; i++) {
            int days = scan.nextInt();
            int fee = scan.nextInt();
            a[i] = new Consult(days, fee);
        }
        for (int i = 1; i <= n; i++) {
            if (i + a[i].days <= n + 1) {
                d[i + a[i].days] = Math.max(d[i] + a[i].fee, d[i + a[i].days]);
            }
            d[i + 1] = Math.max(d[i + 1], d[i]);
        }
        int max = 0;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(d[i], max);
        }
        System.out.println(max);
    }

    static class Consult {
        int days;
        int fee;

        public Consult(int days, int fee) {
            this.days = days;
            this.fee = fee;
        }
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
