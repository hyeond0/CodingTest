import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dat;
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        N = scan.nextInt();
        dat = new int[2000001];
        int head = 0, tail = 0;
        for (int i = 0; i < N; i++) {
            String command = scan.next();
            switch (command) {
                case "push":
                    dat[tail++] = scan.nextInt();
                    break;
                case "pop":
                    if (head == tail) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dat[head++]).append('\n');
                    }
                    break;
                case "size":
                    sb.append(tail - head).append('\n');
                    break;
                case "empty":
                    if (head == tail) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    if (head == tail) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dat[head]).append('\n');
                    }
                    break;
                case "back":
                    if (head == tail) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(dat[tail - 1]).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
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
