import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        N = scan.nextInt();
        int present = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            if (num > present) {
                while (num > present) {
                    stack.add(++present);
                    sb.append('+').append('\n');
                }
                stack.pop();
                sb.append('-').append('\n');
            } else {
                if (stack.isEmpty() || num > stack.peek()) {
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                } else {
                    while (!stack.isEmpty() && num <= stack.peek()) {
                        stack.pop();
                        sb.append('-').append('\n');
                    }
                }
            }
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
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
