import java.util.*;

public class Main {
    static int N,M;
    static int[] A,B;
    static StringBuilder sb = new StringBuilder();
    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B = new int[M+1];
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static int findNumber(int[] A, int L, int R, int X) {
        // 값을 탐색해서 맞다면 반환, 아니면 0 반환
        int result = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == X) {
                result = 1;
                break;
            } else if (A[mid] < X) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }
    static void pro() {
        //A를 정렬 후 B에 있는 값들을 이진탐색
        Arrays.sort(A, 1, N+1);

        for (int i = 1; i <= M; i++) {
            // B에 값들을 대조해서 있는지 확인. 있다면 1, 없다면 0
            sb.append(findNumber(A, 1, N, B[i])).append('\n');
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}