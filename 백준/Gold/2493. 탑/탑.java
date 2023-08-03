import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        stack.add(Integer.parseInt(st.nextToken()));
        System.out.print(0 + " ");
        index.add(1);

        for (int i = 1; i < n; i++) {
            boolean isNone = true;
            int num = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (num > stack.peek()) {
                    stack.pop();
                    index.pop();
                } else {
                    isNone = false;
                    if (!index.isEmpty()) System.out.print(index.peek() + " ");
                    break;
                }
            }
            if (isNone) {
                System.out.print(0 + " ");

            }
            stack.add(num);
            index.add(i+1);
        }
    }
}