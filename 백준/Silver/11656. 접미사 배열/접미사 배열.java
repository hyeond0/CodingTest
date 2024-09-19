import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static String S;
    static String[] a;
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        S = scan.next();
        a = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            a[i] = S.substring(i);
        }
        Arrays.sort(a);
        for (String s : a) {
            sb.append(s).append('\n');
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
