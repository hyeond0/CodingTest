import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String N;
    static int[] A;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextLine();
        char[] cArray = N.toCharArray();
        A = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            A[i] = cArray[i] - '0';
        }
    }

    static void pro() {
        int idx = 0;
        while (idx < N.length()) {
            int present_value = A[idx];
            int max = 0;
            int max_idx = 0;
            for (int i = idx + 1; i < N.length(); i++) {
                if (A[i] > max) {
                    max = A[i];
                    max_idx = i;
                }
            }
            if (present_value < max) {
                swap(idx, max_idx);
            }
            idx++;
        }
        for (int i = 0; i < N.length(); i++) {
            sb.append(A[i]);
        }
        System.out.println(sb.toString());
    }

    static void swap(int a, int b) {
        int tmp = 0;
        tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
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
