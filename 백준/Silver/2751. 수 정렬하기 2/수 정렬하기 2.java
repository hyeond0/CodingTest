import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a, tmp;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        merge_sort(0, n);
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append(' ');
        }
        System.out.println(sb);
    }

    static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int first_idx = st;
        int second_idx = mid;
        for (int i = st; i < en; i++) {
            if (first_idx == mid) {
                tmp[i] = a[second_idx++];
            } else if (second_idx == en) {
                tmp[i] = a[first_idx++];
            } else if (a[first_idx] < a[second_idx]) {
                tmp[i] = a[first_idx++];
            } else {
                tmp[i] = a[second_idx++];
            }
        }

        for (int i = st; i < en; i++) {
            a[i] = tmp[i];
        }
    }

    static void merge_sort(int st, int en) {
        if (en - st == 1) {
            return;
        }
        int mid = (st + en) / 2;
        merge_sort(st, mid);
        merge_sort(mid, en);
        merge(st, en);
    }

    static void input() {
        n = scan.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        tmp = new int[n];
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
