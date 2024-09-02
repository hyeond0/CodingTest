import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static Stack<Character> stack;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        N = scan.nextInt();
        while (N-- > 0) {
            pro();
        }
        System.out.println(ans);
    }

    static void pro() {
        stack = new Stack<>();
        boolean isValid = true;
        for (char c : scan.nextLine().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        if (!stack.isEmpty()) {
            isValid = false;
        }
        if (isValid) {
            ans++;
        }
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
