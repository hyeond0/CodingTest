import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int[][] A = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (scan.nextInt() == 0) {
                    A[i][0]++;
                } else {
                    A[i][1]++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            switch (A[i][0]) {
                case 0:
                    sb.append('E').append('\n');
                    break;
                case 1:
                    sb.append('A').append('\n');
                    break;
                case 2:
                    sb.append('B').append('\n');
                    break;
                case 3:
                    sb.append('C').append('\n');
                    break;
                case 4:
                    sb.append('D').append('\n');
                    break;
            }
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
