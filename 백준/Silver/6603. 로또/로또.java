import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, S;
    static int[] arr, selected;
    static final int LOTTO_NUMBER = 6;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            n = scan.nextInt();
            if (n == 0) {
                break;
            }
            input();
            rec_func(0);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void rec_func(int k) {
        if (k == LOTTO_NUMBER) {
            for (int i = 0; i < LOTTO_NUMBER; i++) {
                sb.append(arr[selected[i]]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int st = 0;
        if (k != 0) {
            st = selected[k - 1] + 1;
        }
        for (int i = st; i < n; i++) {
            selected[k] = i;
            rec_func(k + 1);
        }
    }

    static void input() {
        arr = new int[n];
        selected = new int[LOTTO_NUMBER];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
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
