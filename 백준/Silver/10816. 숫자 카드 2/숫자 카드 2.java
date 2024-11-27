import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] a;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
        m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int target = scan.nextInt();
            sb.append(upper_idx(target, n) - lower_idx(target, n)).append(' ');
        }
        System.out.println(sb);
    }

    static int lower_idx(int target, int len) {
        int st = 0;
        int en = len;
        while (st < en) {
            int mid = (st + en) / 2;
            if (a[mid] >= target) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    static int upper_idx(int target, int len) {
        int st = 0;
        int en = len;
        while (st < en) {
            int mid = (st + en) / 2;
            if (a[mid] > target) {
                en = mid;
            } else {
                st = mid + 1;
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
