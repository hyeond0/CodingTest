import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int na, nb;
    static int[] a, b;
    static List<Integer> none;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        na = scan.nextInt();
        nb = scan.nextInt();
        a = new int[na];
        b = new int[nb];
        for (int i = 0; i < na; i++) {
            a[i] = scan.nextInt();
        }

        for (int i = 0; i < nb; i++) {
            b[i] = scan.nextInt();
        }

        Arrays.sort(b);
        none = new ArrayList<>();
        for (int i : a) {
            if (Arrays.binarySearch(b, i) < 0) {
                none.add(i);
            }
        }
        Collections.sort(none);
        sb.append(none.size()).append('\n');
        for (Integer i : none) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
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
