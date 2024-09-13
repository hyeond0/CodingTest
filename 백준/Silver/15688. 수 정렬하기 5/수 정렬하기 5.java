import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a, count;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        counting_sort();
        System.out.println(sb);
    }

    static void counting_sort() {
        for (int i = 0; i <= 2000000; i++) {
            while (count[i]-- > 0) {
                sb.append(i - 1000000).append('\n');
            }
        }
    }

    static void input() {
        n = scan.nextInt();
        a = new int[n];
        count = new int[2000001];
        for (int i = 0; i < n; i++) {
            count[scan.nextInt() + 1000000]++;
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
