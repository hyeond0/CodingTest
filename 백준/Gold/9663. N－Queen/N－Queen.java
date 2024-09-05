import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, count;
    static int[] selected;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        selected = new int[n];
        for (int i = 0; i < n; i++) {
            selected[i] = -1;
        }
        func(0);
        System.out.println(count);
    }

    static void func(int cur) {
        if (cur == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!is_attackable(cur, i)) {
                selected[cur] = i;
                func(cur + 1);
                selected[cur] = -1;
            }
        }
    }

    static boolean is_attackable(int x, int y) {
        for (int i = 0; i < n; i++) {
            if (selected[i] == y) {
                return true;
            }

            if (selected[i] != -1 && i + selected[i] == x + y) {
                return true;
            }

            if (selected[i] != -1 && i - selected[i] + n - 1 == x - y + n - 1) {
                return true;
            }
        }
        return false;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
