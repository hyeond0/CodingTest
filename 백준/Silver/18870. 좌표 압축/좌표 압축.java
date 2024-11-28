import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] x;
    static List<Integer> uni;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = scan.nextInt();
        x = new int[n];
        uni = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x[i] = scan.nextInt();
            uni.add(x[i]);
        }
        uni = new ArrayList<>(new HashSet<>(uni));
        Collections.sort(uni);
        for (int i = 0; i < n; i++) {
            int position = lower_idx(x[i], uni.size());
            sb.append(position).append(' ');
        }
        System.out.println(sb);
    }

    static int lower_idx(int target, int len) {
        int st = 0;
        int en = len;
        while (st < en) {
            int mid = (st + en) / 2;
            if (uni.get(mid) >= target) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
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
