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
        Dy = new int[1010];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 3;
        for (int i = 4; i <= 1000; i++) {
            Dy[i] = (Dy[i-1] + Dy[i-2]) % 10007;
        }
        System.out.println(Dy[n]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
