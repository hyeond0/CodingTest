import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static String[] arr, selected;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        Arrays.sort(arr);
        rec_func(0, 0);
        System.out.println(sb);
    }

    static void input() {
        L = scan.nextInt();
        C = scan.nextInt();
        arr = new String[C];
        selected = new String[C];
        isUsed = new boolean[C];
        for (int i = 0; i < C; i++) {
            arr[i] = scan.next();
        }
    }

    static void rec_func(int k, int st) {
        if (k == L) {
            if (password_check()) {
                for (int i = 0; i < L; i++) {
                    sb.append(selected[i]);
                }
                sb.append('\n');
            }
        }
        for (int i = st; i < C; i++) {
            if (!isUsed[i]) {
                selected[k] = arr[i];
                isUsed[i] = true;
                rec_func(k + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }

    static boolean password_check() {
        int mo_count = 0;
        int ja_count = 0;
        for (int i = 0; i < L; i++) {
            switch (selected[i]) {
                case "a":
                case "e":
                case "i":
                case "o":
                case "u":
                    mo_count++;
                    break;
                default:
                    ja_count++;
                    break;
            }
        }
        return mo_count >= 1 && ja_count >= 2;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

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
    }
}
