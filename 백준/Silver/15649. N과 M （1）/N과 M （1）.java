import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean isUsed = false;
                for (int i = 1; i < k; i++) {
                    if (cand == selected[i]) {
                        isUsed = true;
                    }
                }
                if (!isUsed) {
                    selected[k] = cand;
                    rec_func(k + 1);
                    selected[k] = 0;
                }
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
    }
}