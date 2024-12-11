import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, c;
    static int[] x;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        c = scan.nextInt();
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(x);
        int st = 1, en = 1000000000;
        while (st < en) {
            int mid = (st + en + 1) / 2;
            if (solve(mid)) {
                st = mid;
            } else {
                en = mid - 1;
            }
        }

        System.out.println(st);
    }

    static boolean solve(int length) {
        int idx = 0, cnt = 0;
        while (idx != n) {
            idx = lower_bound(x[idx] + length, idx);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            cnt++;
        }
        return cnt >= c;
    }

    static int lower_bound(int target, int st) {
        int en = n;
        while (st < en) {
            int mid = (st + en) / 2;
            if (x[mid] < target) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }
        return st;
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
