import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        A = new int[21];
        for (int i = 1; i <= 20; i++) {
            A[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int j = 0;
            while (x + j < y - j) {
                swap(x + j, y - j);
                j++;
            }
        }
        for (int i = 1; i <= 20; i++) {
            sb.append(A[i]).append(' ');
        }
        System.out.println(sb);
    }

    static void swap(int x, int y) {
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }

    static int calc_min(int time) {
        return (time / 60 + 1) * 15;
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
