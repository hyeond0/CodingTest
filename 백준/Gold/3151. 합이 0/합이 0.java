import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        n = scan.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = -(a[i] + a[j]);
                int upper = upper_idx(target, j + 1);
                int lower = lower_idx(target, j + 1);
                ans += upper - lower;
            }
        }
        System.out.println(ans);
    }

    static int lower_idx(int target, int start) {
        int st = start;
        int en = n;
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

    static int upper_idx(int target, int start) {
        int st = start;
        int en = n;
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
