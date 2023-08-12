import java.util.*;
import java.io.*;

public class Main {
    static int N, min;
    static int[] selected;
    static int[][] W;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        selected = new int[N+1];
        W = new int[N+1][N+1];
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void ref_func(int k) {
        if (k == N + 1) {
            calcPrice();
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean isUsed = false;
                for (int i = 1; i < k; i++) {
                    if (cand == selected[i]) isUsed = true;
                }
                if (!isUsed) {
                    selected[k] = cand;
                    ref_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    private static void calcPrice() {
        int sum = 0;
        if (W[selected[N]][selected[1]] == 0) return;
        for (int i = 1; i < N; i++) {
            if (W[selected[i]][selected[i+1]] == 0) return;
            sum += W[selected[i]][selected[i+1]];
        }
        sum += W[selected[N]][selected[1]];
        min = Math.min(sum, min);
    }


    public static void main(String[] args) throws IOException {
        input();
        ref_func(1);
        System.out.println(min);
    }
}