import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int A[] = new int[N];
        int S[] = new int[N];
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            A[i] = num;
            if (i==0) {
                S[i] = num;
            }
            else {
                S[i] = S[i-1] + num;
            }
        }

        for (int i = 0; i < M; i++) {
            int answer = 0;
            int section1 = sc.nextInt();
            int section2 = sc.nextInt();
            if (section1 == 1) {
                answer = S[section2-1];
            }
            else {
                answer = S[section2-1] - S[section1-2];
            }
            System.out.println(answer);
        }
    }
}
