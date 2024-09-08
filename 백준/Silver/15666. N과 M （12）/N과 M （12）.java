import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] selected, arr;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n];
        selected = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        rec_func(0, 0);
        System.out.println(sb.toString());
    }

    static void rec_func(int k, int st) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int tmp = -1;
        for (int i = st; i < n; i++) {
            if (arr[i] != tmp) {
                selected[k] = arr[i];
                tmp = selected[k];
                rec_func(k + 1, i);
            }
        }
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
