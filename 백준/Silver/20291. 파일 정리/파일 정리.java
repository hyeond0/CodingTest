import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static String[] a;
    static StringBuilder sb = new StringBuilder();
    private static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            String b = sc.next().split("\\.")[1];
            a[i] = b;
        }
    }

    private static void pro() {
        Arrays.sort(a);
        int count = 1;
        for (int i = 1; i <= N; i++) {
            if (i != N && a[i].equals(a[i-1])) count++;
            else {
                sb.append(a[i-1]).append(' ').append(count).append('\n');
                count = 1;
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
