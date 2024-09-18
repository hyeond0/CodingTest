import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Elem[] a;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        N = scan.nextInt();
        a = new Elem[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            a[idx] = new Elem(idx, scan.nextInt(), scan.next());
        }
    }

    static void pro() {
        Arrays.sort(a, 1, N + 1);
        for (int i = 1; i <= N; i++) {
            sb.append(a[i].age).append(' ').append(a[i].name).append('\n');
        }
        System.out.println(sb);
    }


    static class Elem implements Comparable<Elem> {
        int idx;
        int age;
        String name;

        public Elem(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        public int compareTo(Elem other) {
            if (age == other.age) {
                return idx - other.idx;
            }
            return age - other.age;
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
    }
}
