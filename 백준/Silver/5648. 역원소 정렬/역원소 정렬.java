import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Elem[] a;
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        a = new Elem[N];
        StringBuilder rev = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String element = scan.next();
            char[] cArray = element.toCharArray();
            boolean isFirst = true;
            rev.setLength(0);
            for (int j = cArray.length - 1; j >= 0; j--) {
                if (isFirst && cArray[j] == '0') {
                    continue;
                }
                isFirst = false;
                rev.append(cArray[j]);
            }
            a[i] = new Elem(Long.parseLong(rev.toString()));
        }
    }

    static void pro() {
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            sb.append(a[i].element).append('\n');
        }
        System.out.println(sb);
    }


    static class Elem implements Comparable<Elem> {
        long element;

        public Elem(long element) {
            this.element = element;
        }

        public int compareTo(Elem other) {
            if (element > other.element) {
                return 1;
            } else if (element == other.element) {
                return 0;
            }
            return -1;
        }
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
    }
}
