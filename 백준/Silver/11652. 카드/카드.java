import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] arr;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }
    }

    static void pro() {
        Arrays.sort(arr);
        int cnt = 0, maxCnt = 0;
        long maxVal = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    maxVal = arr[i - 1];
                }
                cnt = 1;
            }
        }
        if (cnt > maxCnt) {
            maxVal = arr[n - 1];
        }
        System.out.println(maxVal);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
