import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] stack;
    static int N, pos;

    public static void main(String[] args) {
        N = scan.nextInt();
        stack = new int[10001];
        pos = 0;
        for (int i = 0; i < N; i++) {
            String command = scan.next();
            switch (command) {
                case "push":
                    push(scan.nextInt());
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    static void push(int x) {
        stack[pos++] = x;
    }

    static int pop() {
        if (pos == 0) {
            return -1;
        }
        return stack[--pos];
    }

    static int top() {
        if (pos == 0) {
            return -1;
        }
        return stack[pos - 1];
    }

    static int empty() {
        if (pos == 0) {
            return 1;
        }
        return 0;
    }

    static int size() {
        return pos;
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
