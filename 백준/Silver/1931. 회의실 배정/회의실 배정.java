import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Meeting[] a;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        a = new Meeting[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new Meeting(scan.nextInt(), scan.nextInt());
        }
    }

    static void pro() {
        Arrays.sort(a, 1, n + 1);
        int time = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (time > a[i].start) {
                continue;
            }
            ans++;
            time = a[i].end;
        }
        System.out.println(ans);
    }


    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other) {
            if (end == other.end) {
                return start - other.start;
            }
            return end - other.end;
        }
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
