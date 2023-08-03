import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        ArrayList<Integer> answerArray = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        
        // 제일 왼쪽 타워는 0
        stack.add(Integer.parseInt(st.nextToken()));
        answerArray.add(0);
        index.add(1);

        for (int i = 1; i < n; i++) {
            boolean isNone = true; // 더 높은 타워가 없는지 Check
            int num = Integer.parseInt(st.nextToken()); 
            while (!stack.isEmpty()) {
                if (num > stack.peek()) { // 왼쪽 타워가 높이가 더 낮은 타워라면
                    stack.pop();
                    index.pop();
                } else { // 높이가 더 높은 타워를 찾았다면
                    isNone = false;
                    answerArray.add(index.peek());
                    break;
                }
            }
            if (isNone) { // 더 높은 타워가 없다면
                answerArray.add(0);

            }
            stack.add(num);
            index.add(i+1);
        }

        for (int i = 0; i< answerArray.size(); i++) {
            System.out.print(answerArray.get(i) + " ");
        }
    }
}