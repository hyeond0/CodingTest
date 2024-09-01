import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String p;
    static Deque<Integer> deque;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }

    static void input() {
        p = scan.nextLine();
        n = scan.nextInt();
        deque = new ArrayDeque<>();
        String arr = scan.nextLine();
        String[] numbers = arr.substring(1, arr.length() - 1).split(",");
        for (String num : numbers) {
            String trim = num.trim();
            if (!trim.isEmpty()) {
                deque.offer(Integer.parseInt(trim));
            }
        }
    }

    static void pro() {
        int RCount = 0;
        for (char c : p.toCharArray()) {
            if (c == 'R') {
                RCount++;
            } else {
                if (deque.isEmpty()) {
                    sb.append("error").append('\n');
                    return;
                }
                if (RCount % 2 == 0) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }

        sb.append('[');
        if (RCount % 2 == 0) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                if (!deque.isEmpty()) {
                    sb.append(',');
                }
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
                if (!deque.isEmpty()) {
                    sb.append(',');
                }
            }
        }
        sb.append(']').append('\n');
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
