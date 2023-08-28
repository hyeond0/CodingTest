import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Scanner scan = new Scanner(System.in);
    static int N, M;
    static String[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.next();
        }
    }
    static boolean binary_search(String[] A, int L, int R, String X) {
        while(L <= R) {
            int mid = (L + R) / 2;
            if (A[mid].equals(X)) return true;

            if (A[mid].compareTo(X) > 0) // A가 더 클때
                R = mid - 1;
            else
                L = mid + 1;
        }
        return false;
    }
    static void pro() {
        // A 정렬하기
        Arrays.sort(A,1,N+1);
        // M 입력받기
        List<String> dbj = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            String X = scan.next();
            if (binary_search(A,1,N,X)) dbj.add(X);
        }
        sb.append(dbj.size()).append('\n');
        Collections.sort(dbj);

        for (String name : dbj) sb.append(name).append('\n');
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}
