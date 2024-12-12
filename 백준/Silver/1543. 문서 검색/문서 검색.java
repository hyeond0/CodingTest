import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String doc, word;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        doc = scan.nextLine();
        word = scan.nextLine();
    }

    static void pro() {
        int ans = 0;
        while (!doc.isEmpty()) {
            if (doc.startsWith(word)) {
                ans++;
                doc = doc.substring(word.length());
            } else {
                doc = doc.substring(1);
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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
    }
}
