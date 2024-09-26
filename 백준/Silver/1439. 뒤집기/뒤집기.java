import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String s;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        s = scan.next();
        char prev = s.charAt(0);
        int[] a = new int[2];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                a[prev - '0']++;
            }
            prev = s.charAt(i);
        }
        System.out.println(Math.max(a[0], a[1]));
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
