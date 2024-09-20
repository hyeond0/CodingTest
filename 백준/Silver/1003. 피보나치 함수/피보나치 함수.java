import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] fibo;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int T = scan.nextInt();
        fibo = new int[42][2];
        fibo[0][0] = 1;
        fibo[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
            fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
        }
        while (T-- > 0) {
            n = scan.nextInt();
            sb.append(fibo[n][0]).append(' ').append(fibo[n][1]).append('\n');
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
