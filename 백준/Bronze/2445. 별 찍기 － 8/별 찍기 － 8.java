import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = scan.nextInt();
        for (int i = 1; i <= 2 * N; i += 2) {
            for (int j = 1; j <= i / 2 + 1; j++) {
                sb.append('*');
            }
            for (int k = (2 * N - 1) - i; k >= 1; k--) {
                sb.append(' ');
            }
            for (int j = 1; j <= i / 2 + 1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }
        for (int i = (2 * N - 1) - 2; i >= 1; i -= 2) {
            for (int j = 1; j <= i / 2 + 1; j++) {
                sb.append('*');
            }
            for (int k = (2 * N - 1) - i; k >= 1; k--) {
                sb.append(' ');
            }
            for (int j = 1; j <= i / 2 + 1; j++) {
                sb.append('*');
            }
            sb.append('\n');
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

        long nextLong() {
            return Long.parseLong(next());
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
    }
}
