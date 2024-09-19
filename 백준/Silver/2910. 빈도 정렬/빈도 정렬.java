import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static List<Elem> a;
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            boolean find = false;
            for (Elem e : a) {
                if (e.value == num) {
                    e.count++;
                    find = true;
                    break;
                }
            }
            if (!find) {
                a.add(new Elem(i, 1, num));
            }
        }
    }

    static void pro() {
        Collections.sort(a);
        for (Elem e : a) {
            for (int i = 0; i < e.count; i++) {
                sb.append(e.value).append(' ');
            }
        }
        System.out.println(sb);
    }


    static class Elem implements Comparable<Elem> {
        int count;
        int value;
        int first;

        public Elem(int first, int count, int value) {
            this.first = first;
            this.count = count;
            this.value = value;
        }

        public int compareTo(Elem other) {
            if (count == other.count) {
                return first - other.first;
            }
            return other.count - count;
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
