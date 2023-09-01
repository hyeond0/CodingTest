
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();


    static int N, M;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + M + 1];
        for (int i = 1; i <= N + M; i++) {
            A[i] = scan.nextInt();
        }
    }

    private static void pro() {
        Arrays.sort(A, 1, N + M + 1);
        for (int i = 1; i <= N + M; i++) sb.append(A[i]).append(' ');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}