import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int[] A = new int[1000001];
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            A[scan.nextInt()]++;
        }
        int X = scan.nextInt();
        int ans = 0;
        for (int i = 1; i <= 1000000; i++) {
            if (A[i] > 0) {
                if (X - i > 0 && X - i < 1000001 && A[X - i] > 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans / 2);
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
