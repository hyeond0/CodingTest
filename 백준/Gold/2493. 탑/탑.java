import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = scan.nextInt();
        Stack<Top> stack = new Stack<>();
        Stack<Top> stack2 = new Stack<>();
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stack.push(new Top(i, scan.nextInt()));
        }
        stack2.push(stack.pop());
        while (!stack.isEmpty()) {
            Top pop = stack.pop();
            while (!stack2.isEmpty()) {
                Top peek = stack2.peek();
                if (pop.value > peek.value) {
                    A[peek.idx] = pop.idx;
                    stack2.pop();
                } else {
                    break;
                }
            }
            stack2.push(pop);
        }
        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append(' ');
        }
        System.out.println(sb);
    }

    static class Top {
        private final int idx;
        private final int value;

        public Top(int idx, int value) {
            this.idx = idx;
            this.value = value;
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
