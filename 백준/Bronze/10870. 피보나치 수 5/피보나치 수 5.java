import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] Dy;
    static int n;

    private static void input() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
    }

    private static void pro() {
        Dy = new int[25];
        Dy[0] = 0;
        Dy[1] = 1;
        for (int i = 2; i <= n; i++) {
            Dy[i] = Dy[i-1] + Dy[i-2];
        }
        System.out.println(Dy[n]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
