
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();


    static int N, K;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    private static void pro() {

        int R = 0, count = 0, ans = N + 1;
        for (int L = 1; L <= N; L++) {
            if (A[L - 1] == 1) count--;
            while (R + 1 <= N && count < K) {
                if (A[++R] == 1) count++;
            }
            if (count == K) ans = Math.min(ans, R - L + 1);
        }
        if (ans <= N) System.out.println(ans);
        else System.out.println(-1);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}