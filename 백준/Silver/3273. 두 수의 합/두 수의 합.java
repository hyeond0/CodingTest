import java.util.*;
import java.io.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A;
    static void input() {
        N = scan.nextInt();
        A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean binary_search(int[] A, int L, int R, int X, int value) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] + value == X) return true;

            if (A[mid] + value > X) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return false;
    }
    static void pro() {
        int X = scan.nextInt();
        Arrays.sort(A, 1, N+1);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (binary_search(A, i+1, N, X, A[i])) count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        input();
        pro();
    }
}
