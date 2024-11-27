import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        N = scan.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        Arrays.sort(A);
        M = scan.nextInt();
        for (int i = 0; i < M; i++) {
            int target = scan.nextInt();
            sb.append(binary_search(target)).append('\n');
        }
        System.out.println(sb);
    }

    static int binary_search(int target) {
        int st = 0;
        int en = N - 1;
        while (st <= en) {
            int mid = (st + en) / 2;
            if (A[mid] > target) {
                en = mid - 1;
            } else if (A[mid] < target) {
                st = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
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
