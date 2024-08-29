import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] selected, A;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        A = new int[10];
        for (int i = 1; i <= 9; i++) {
            A[i] = scan.nextInt();
        }
        selected = new int[8];
        Arrays.sort(A);
        rec_func(1);
    }

    static void rec_func(int k) {
        if (k == 8) {
            int sum = 0;
            for (int i = 1; i <= 7; i++) {
                sum += A[selected[i]];
                sb.append(A[selected[i]]).append('\n');
            }
            if (sum == 100) {
                System.out.println(sb);
                System.exit(0);
            } else {
                sb.setLength(0);
            }
        } else {
            for (int cand = selected[k - 1] + 1; cand <= 9; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
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
