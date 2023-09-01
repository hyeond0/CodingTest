
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] a, b;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        a = new int[n + 1];
        b = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            b[i] = scan.nextInt();
        }
    }

    private static void pro() {
        int L = 1, R = 1;
        // a와 b를 앞에서부터 하나씩 추출해서 출력한다. 단, 둘 다 비어있지 않은 경우와 그것이 아닌 경우를 잘 나누자.
        /* TODO */
        while (L <= n && R <= m) {
            if (a[L] <= b[R]) sb.append(a[L++]).append(' ');
            else sb.append(b[R++]).append(' ');
        }
        while (L <= n) sb.append(a[L++]).append(' ');
        while (R <= m) sb.append(b[R++]).append(' ');

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}