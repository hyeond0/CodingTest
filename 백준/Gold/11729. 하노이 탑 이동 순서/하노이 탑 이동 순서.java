import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        N = scan.nextInt();
        sb.append((int) Math.pow(2, N) - 1).append('\n');
        rec_func(1, 3, N);
        System.out.println(sb);
    }

    static void rec_func(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(' ').append(b).append('\n');
            return;
        }
        rec_func(a, 6 - a - b, n - 1);
        sb.append(a).append(' ').append(b).append('\n');
        rec_func(6 - a - b, b, n - 1);
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
