import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] A;
    static Scanner scan = new Scanner(System.in);
    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }

    static boolean detemination(int budget) {
        // 예산의 최댓값
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (A[i] >= budget) sum += budget;
            else sum += A[i];
        }
        return sum <= M;
    }

    static void pro() {
        // A 정렬
        Arrays.sort(A, 1, N+1);
        int L = 0, R = M, result = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (detemination(mid)) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        // 최댓값 탐색
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, A[i]);
        }
        if (max <= result) System.out.println(max);
        else System.out.println(result);
    }


    public static void main(String[] args) {
        input();
        pro();
    }
}
