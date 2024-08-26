import java.io.*;
import java.util.*;

public class Main {
    static FastReader sc = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] S = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            S[i] = S[i - 1] + num;
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(S[j] - S[i - 1]);
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
