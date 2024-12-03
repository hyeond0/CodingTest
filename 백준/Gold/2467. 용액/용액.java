import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a, ans;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        a = new int[n];
        ans = new int[2];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
        ans[0] = 1000000000;
        ans[1] = 1000000000;
        for (int i = 0; i < n; i++) {
            int idx = lower_idx(-a[i], n);
            if (idx + 1 < n && i != idx + 1 && Math.abs(a[i] + a[idx + 1]) < Math.abs(ans[0] + ans[1])) {
                ans[0] = a[i];
                ans[1] = a[idx + 1];
            }
            if (idx < n && i != idx && Math.abs(a[i] + a[idx]) < Math.abs(ans[0] + ans[1])) {
                ans[0] = a[i];
                ans[1] = a[idx];
            }
            if (idx != 0 && i != idx - 1 && Math.abs(a[i] + a[idx - 1]) < Math.abs(ans[0] + ans[1])) {
                ans[0] = a[i];
                ans[1] = a[idx - 1];
            }
        }
        sb.append(Math.min(ans[0], ans[1])).append(' ').append(Math.max(ans[0], ans[1]));
        System.out.println(sb);
    }

    static int lower_idx(int target, int len) {
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
