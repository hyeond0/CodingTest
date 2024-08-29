import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int[] alphabet_first = new int[27];
            int[] alphabet_second = new int[27];
            char[] first = scan.next().toCharArray();
            char[] second = scan.next().toCharArray();
            if (first.length != second.length) {
                sb.append("Impossible").append("\n");
                continue;
            }
            for (int j = 0; j < first.length; j++) {
                alphabet_first[first[j] - 'a']++;
                alphabet_second[second[j] - 'a']++;
            }
            boolean isPossible = true;
            for (int k = 0; k < alphabet_first.length; k++) {
                if (alphabet_first[k] != alphabet_second[k]) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                sb.append("Possible").append('\n');
            } else {
                sb.append("Impossible").append("\n");
            }
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
