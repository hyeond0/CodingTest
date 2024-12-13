import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer> a;
    static boolean[] state;
    static int MAX_LENGTH = 4000000;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        state = new boolean[MAX_LENGTH + 1];
        a = new ArrayList<>();
        sieve(n); // 400만 이하의 소수 리스트
        for (int i = 1; i <= n; i++) {
            if (state[i]) {
                a.add(i);
            }
        }
    }

    static void pro() {
        if (a.isEmpty()) {
            System.out.println(0);
        } else {
            int en = 0, ans = 0, sum = a.get(0);
            for (int st = 0; st < a.size(); st++) {
                while (en < a.size() && sum < n) {
                    en++;
                    if (en >= a.size()) {
                        break;
                    }
                    sum += a.get(en);
                }
                if (en == a.size()) {
                    break;
                }
                if (sum == n) {
                    ans++;
                }
                sum -= a.get(st);
            }
            System.out.println(ans);
        }
    }

    static void sieve(int n) {
        Arrays.fill(state, true);
        state[0] = false;
        state[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (!state[i]) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                state[j] = false;
            }
        }
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
