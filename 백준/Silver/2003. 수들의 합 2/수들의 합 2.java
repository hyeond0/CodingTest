
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();


    static int n, m;
    static int[] a;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
    }
    private static void pro() {
        int R = 0, sum = 0, count = 0;
        for (int L = 1; L <= n; L++) {
            sum -= a[L-1];
            while (R+1 <= n && sum < m) {
                R++;
                sum += a[R];
            }
            if (sum == m) count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}