import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a, d, pre;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        a = new int[1005];
        d = new int[1005];
        pre = new int[1005];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    pre[i] = j;
                }
            }
        }

        int max = 0;
        int max_idx = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] > max) {
                max = d[i];
                max_idx = i;
            }
        }
        sb.append(max).append('\n');
        Stack<Integer> stack = new Stack<>();
        int cur = max_idx;

        while (cur != 0) {
            stack.push(cur);
            cur = pre[cur];
        }

        while (!stack.isEmpty()) {
            sb.append(a[stack.pop()]).append(' ');
        }
        System.out.println(sb);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
