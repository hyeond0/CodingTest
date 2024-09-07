import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, selected;
    static boolean[] isUsed;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n];
        selected = new int[n];
        isUsed = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        rec_func(0);
        System.out.println(sb);
    }

    static void rec_func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[selected[i]]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int before = -1;
        int st = 0;
        if (k != 0) {
            st = selected[k - 1] + 1;
        }
        for (int i = st; i < n; i++) {
            if (!isUsed[i] && arr[i] != before) {
                selected[k] = i;
                before = arr[i];
                isUsed[i] = true;
                rec_func(k + 1);
                isUsed[i] = false;
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
