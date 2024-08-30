import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            LinkedList<Character> password = new LinkedList<>();
            char[] charArray = scan.nextLine().toCharArray();
            ListIterator<Character> listIterator = password.listIterator();
            for (char c : charArray) {
                switch (c) {
                    case '-':
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                            listIterator.remove();
                        }
                        break;
                    case '<':
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        break;
                    case '>':
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        break;
                    default:
                        listIterator.add(c);
                        break;
                }
            }
            for (Character c : password) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
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
