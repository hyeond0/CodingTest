import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static Map<Integer, String> a;
    static Map<String, Integer> b;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        a = new HashMap<>();
        b = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = scan.next();
            a.put(i, name);
            b.put(name, i);
        }
    }

    static void pro() {
        for (int i = 0; i < m; i++) {
            String prob = scan.next();
            if (Character.isDigit(prob.charAt(0))) {
                sb.append(a.get(Integer.parseInt(prob)));
            } else {
                sb.append(b.get(prob));
            }
            sb.append('\n');
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
