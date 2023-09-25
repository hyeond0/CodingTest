import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] DyZero, DyOne;

    private static void preprocess() {
        DyZero = new int[45];
        DyOne = new int[45];
        DyZero[0] = 1;
        DyOne[0] = 0;
        DyZero[1] = 0;
        DyOne[1] = 1;
        DyZero[2] = 1;
        DyOne[2] = 1;
        for (int i = 3; i <= 40; i ++) {
            DyZero[i] = DyZero[i-2] + DyZero[i-1];
            DyOne[i] = DyOne[i-2] + DyOne[i-1];
        }
    }

    private static void pro() {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            sb.append(DyZero[n]).append(' ')
                    .append(DyOne[n]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        preprocess();
        pro();
    }
}
