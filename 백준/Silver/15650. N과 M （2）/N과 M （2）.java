import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int start = selected[k-1];
            // 1-N 까지를 k번
            for (int cand = start + 1; cand <= N; cand++) {
                boolean isUsed = false;
                for (int i = 1; i <= k; i++) {
                    if (selected[i] == cand) isUsed = true;
                }
                if (!isUsed) {
                    selected[k] = cand;
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M+1];
        rec_func(1);
        System.out.println(sb.toString());
    }
}