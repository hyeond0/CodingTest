import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, count;
    static boolean[] isUsed1, isUsed2, isUsed3;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        isUsed1 = new boolean[n];
        isUsed2 = new boolean[2 * n - 1];
        isUsed3 = new boolean[2 * n - 1];
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
                isUsed1[i] = true;
                isUsed2[cur + i] = true;
                isUsed3[cur - i + n - 1] = true;
                func(cur + 1);
                isUsed1[i] = false;
                isUsed2[cur + i] = false;
                isUsed3[cur - i + n - 1] = false;
            }
        }
    }

    static boolean is_attackable(int x, int y) {
        if (isUsed1[y]) {
            return true;
        }
        if (isUsed2[x + y]) {
            return true;
        }
        return isUsed3[x - y + n - 1];
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
