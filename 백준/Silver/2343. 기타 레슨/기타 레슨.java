import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] A;
    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        A =new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    private static boolean determination(int length) {
        int[] B = new int[M+1];
        int index = 1;
        for (int i = 1; i <= N; i++) {
            // 블루레이 크기보다 커진다면 다음 블루레이에 담기
            if (B[index] + A[i] > length)
                index++;
            // 블루레이 갯수에 다 안담기면 이 길이로는 못 만듦
            if (index > M) return false;
            B[index] += A[i];
        }
        return true; // 잘 담기면 true
    }

    private static void pro() {
        // 탐색
        int L = 0, R = 1000000000, answer = 0;
        for (int i = 1; i <= N; i++) L = Math.max(L, A[i]);
        while (L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
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
