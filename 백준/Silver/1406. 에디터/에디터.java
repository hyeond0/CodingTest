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
        LinkedList<Character> cList = new LinkedList<>();
        String s = scan.nextLine();
        for (int i = 0; i < s.length(); i++) {
            cList.add(s.charAt(i));
        }
        ListIterator<Character> listIterator = cList.listIterator(cList.size());
        int M = scan.nextInt();
        for (int i = 0; i < M; i++) {
            String s1 = scan.nextLine();
            String a = s1.split(" ")[0];
            switch (a) {
                case "P":
                    listIterator.add(s1.split(" ")[1].charAt(0));
                    break;
                case "L":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    break;
                case "B":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                case "D":
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    break;
            }
        }
        for (Character c : cList) {
            sb.append(c);
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
