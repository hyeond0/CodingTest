import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        char[] A = scan.nextLine().toCharArray();
        char[] B = scan.nextLine().toCharArray();
        int[] first = new int[26];
        int[] second = new int[26];
        for (char c : A) {
            first[c - 'a']++;
        }
        for (char c : B) {
            second[c - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] != second[i]) {
                ans += Math.abs(first[i] - second[i]);
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
