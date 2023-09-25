import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] Dy;

    public static void main(String[] args) {
        preprocess();
        pro();
    }

    private static void preprocess() {
        Dy = new int[15];
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;
        for (int i = 4; i <= 11; i++) {
            Dy[i] = Dy[i-1] + Dy[i-2] + Dy[i-3];
        }
    }

    private static void pro() {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            sb.append(Dy[n]).append('\n');
        }
        System.out.println(sb);
    }
}
