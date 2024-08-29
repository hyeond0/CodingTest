import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[][] students = new int[2][7];
        for (int i = 0; i < N; i++) {
            int gender = scan.nextInt();
            int grade = scan.nextInt();
            students[gender][grade]++;
        }
        int ans = 0;
        for (int gender = 0; gender < 2; gender++) {
            for (int grade = 1; grade <= 6; grade++) {
                int student = students[gender][grade];
                if (student == 0) {
                    continue;
                }
                if (student % K > 0) {
                    ans += student / K + 1;
                } else {
                    ans += student / K;
                }
            }
        }
        System.out.println(ans);
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
