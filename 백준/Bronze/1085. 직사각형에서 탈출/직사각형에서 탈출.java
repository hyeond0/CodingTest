import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x, y, w, h;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        x = scan.nextInt();
        y = scan.nextInt();
        w = scan.nextInt();
        h = scan.nextInt();
    }

    static void pro() {
        int min = x;
        if (min > y) {
            min = y;
        }
        if (min > h - y) {
            min = h - y;
        }
        if (min > w - x) {
            min = w - x;
        }

        System.out.println(min);
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
