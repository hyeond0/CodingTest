import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Elem[] a;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        a = new Elem[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Elem(scan.nextInt(), scan.nextInt());
        }
    }

    static void pro() {
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            sb.append(a[i].x).append(' ').append(a[i].y).append('\n');
        }
        System.out.println(sb);
    }


    static class Elem implements Comparable<Elem> {
        int x;
        int y;

        public Elem(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Elem other) {
            if (y == other.y) {
                return x - other.x;
            }
            return y - other.y;
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
    }
}
