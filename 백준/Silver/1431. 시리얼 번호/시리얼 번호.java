import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Serial[] a;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        Arrays.sort(a);
        for (Serial serial : a) {
            sb.append(serial.str).append('\n');
        }
        System.out.println(sb);
    }

    static class Serial implements Comparable<Serial> {
        String str;
        int len;

        public Serial(String str, int len) {
            this.str = str;
            this.len = len;
        }

        public int compareTo(Serial other) {
            if (len == other.len) {
                int strSum = serialNumberSum(str);
                int otherSum = serialNumberSum(other.str);
                if (strSum == otherSum) {
                    return str.compareTo(other.str);
                }
                return serialNumberSum(str) - serialNumberSum(other.str);
            }
            return len - other.len;
        }

        private int serialNumberSum(String s) {
            int sum = 0;
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                if (c >= 'A' && c <= 'Z') {
                    continue;
                }
                sum += c - '0';
            }
            return sum;
        }
    }

    static void input() {
        n = scan.nextInt();
        a = new Serial[n];
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            a[i] = new Serial(s, s.length());
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
