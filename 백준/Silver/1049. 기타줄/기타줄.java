import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] unit, pack;
    static List<Integer> two;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        unit = new int[m];
        pack = new int[m];
        for (int i = 0; i < m; i++) {
            pack[i] = scan.nextInt();
            unit[i] = scan.nextInt();
        }
    }

    static void pro() {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(unit);
        Arrays.sort(pack);

        ans = Math.min(((n / 6) + 1) * pack[0], n * unit[0]);
        ans = Math.min(ans, ((n / 6)) * pack[0] + (n % 6) * unit[0]);

        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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
