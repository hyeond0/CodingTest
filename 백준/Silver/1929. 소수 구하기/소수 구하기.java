import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        List<Integer> primes = sieve(m);
        for (int p : primes) {
            if (p >= n) {
                sb.append(p).append('\n');
            }
        }
        System.out.println(sb);
    }

    static List<Integer> sieve(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> state = new ArrayList<>(Collections.nCopies(n + 1, true));
        state.set(1, false);
        for (int i = 2; i <= n; i++) {
            if (!state.get(i)) {
                continue;
            }
            for (int j = 2 * i; j <= n; j += i) {
                state.set(j, false);
            }
        }
        for (int i = 2; i <= n; i++) {
            if (state.get(i)) {
                primes.add(i);
            }
        }
        return primes;
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
