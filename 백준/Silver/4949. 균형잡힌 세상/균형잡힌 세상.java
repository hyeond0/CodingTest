import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static String line;
    static Stack<Character> stack;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            line = scan.nextLine();
            if (line.equals(".")) {
                break;
            }
            pro();
        }
        System.out.println(sb);
    }

    static void pro() {
        stack = new Stack<>();
        boolean isPossible = true;
        for (char c : line.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isPossible = false;
                        break;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isPossible = false;
                        break;
                    }
                    stack.pop();
                    break;
            }
        }

        if (!stack.isEmpty()) {
            isPossible = false;
        }
        if (isPossible) {
            sb.append("yes");
        } else {
            sb.append("no");
        }
        sb.append('\n');
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
