import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, head, tail;
    ;
    static int[] dat;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        N = scan.nextInt();
        dat = new int[N * 2 + 1];
        head = N;
        tail = N;
        for (int i = 0; i < N; i++) {
            String command = scan.next();
            switch (command) {
                case "push_back":
                    push_back(scan.nextInt());
                    break;
                case "push_front":
                    push_front(scan.nextInt());
                    break;
                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;
                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }

    static void push_front(int x) {
        dat[--head] = x;
    }

    static void push_back(int x) {
        dat[tail++] = x;
    }

    static int pop_front() {
        if (head == tail) {
            return -1;
        }
        return dat[head++];
    }

    static int pop_back() {
        if (head == tail) {
            return -1;
        }
        return dat[--tail];
    }

    static int size() {
        return tail - head;
    }

    static int empty() {
        if (tail == head) {
            return 1;
        }
        return 0;
    }

    static int front() {
        if (tail == head) {
            return -1;
        }
        return dat[head];
    }

    static int back() {
        if (tail == head) {
            return -1;
        }
        return dat[tail - 1];
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
