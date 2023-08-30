import java.io.*;
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] A;

    static void input() {
        K = scan.nextInt();
        N = scan.nextInt();
        A = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determination(long H) {
        // H로 총합을 나눴을 때 11개가 만들어지는지ㅣ
        long sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += A[i] / H;
        }
        return sum >= N;
    }

    static void pro() {
        long L = 1, R = Integer.MAX_VALUE, result = 0;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}