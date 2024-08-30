import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int N = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int K = scan.nextInt();
        sb.append('<');
        while (!list.isEmpty()) {
            for (int i = 1; i <= K; i++) {
                if (i == K) {
                    if (list.size() == 1) {
                        sb.append(list.remove());
                    } else {
                        sb.append(list.remove()).append(", ");
                    }
                } else {
                    list.add(list.remove());
                }
            }
        }
        sb.append('>');
        System.out.println(sb);
    }

    static class Node {
        private final Integer prev;
        private final Integer next;
        private final Integer value;

        public Node(Integer prev, Integer next, Integer value) {
            this.prev = prev;
            this.next = next;
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
