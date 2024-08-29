import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String s = scan.nextLine();
        int[] A = new int[10];
        for (int i = 0; i < s.length(); i++) {
            A[s.charAt(i) - '0']++;
        }
        int max_idx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= 9; i++) {
            if (A[i] > max) {
                max_idx = i;
                max = A[i];
            }
        }
        if (max_idx == 6 || max_idx == 9) {
            int same = Math.round((float) (A[6] + A[9]) / 2);
            A[6] = same;
            A[9] = same;
            max = Integer.MIN_VALUE;
            for (int i = 0; i <= 9; i++) {
                if (A[i] > max) {
                    max = A[i];
                }
            }
        }
        System.out.println(max);
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
