
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();


    static int N, M;
    static boolean[] A;
    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            A[scan.nextInt()] = true;
        }
    }

    private static boolean determination(int height) {
        boolean result = true;
        int present = 0;
        for (int i = 0; i <= N; i++) {
            if (A[i]) {
                if (i - height > present) return false;
                else present = i + height;
            }
        }
        return present >= N;
    }

    private static void pro() {
        int L = 1, R = 100001, answer = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                answer = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}