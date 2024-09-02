import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Character> stack;
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String s = scan.nextLine();
        stack = new Stack<>();
        int ans = 0;
        boolean afterLazer = true;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                afterLazer = false;
                stack.push(c);
            } else {
                if (stack.peek() == '(' && !afterLazer) {
                    stack.pop();
                    ans += stack.size();
                    afterLazer = true;
                } else {
                    stack.pop();
                    ans++;
                }
            }
        }
        System.out.println(ans);
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
