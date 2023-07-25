import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            deque.offer(i);
        }
        int[] arr = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        boolean second = true;
        for (int num : arr) {
            int index = 0;
            for (int element : deque) {
                if (num == element){
                    if (index >= deque.size() / 2 + 1) {
                        second = false;
                    }
                    break;
                }
                index++;
            }
            while (num != deque.peek()){
                if (second) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
                count++;
            }
            deque.remove();
            second=true;
        }
        System.out.println(count);
    }
}
