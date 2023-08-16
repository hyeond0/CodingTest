import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static class Elem implements Comparable<Elem> {

        public int size;
        public int index;

        @Override
        public int compareTo(Elem other) {
            return size - other.size;
        }
    }
    static int N;

    static int[] P;
    static Elem[] A;
    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        A = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Elem();
            A[i].size = scan.nextInt();
            A[i].index = i;
        }
    }

    private static void pro() {
        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            P[A[i].index] = i;
        }

        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}