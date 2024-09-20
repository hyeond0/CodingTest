import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] d;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        d = new int[1001];
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= 1000; i++) {
            d[i] = (d[i - 1] + d[i - 2] * 2) % 10007;
        }
        System.out.println(d[n]);
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
