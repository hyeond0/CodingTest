import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int k = A[i];
            int L = 0, R = N - 1;
            while (L < R) {
                int sum = A[L] + A[R];
                if (sum == k) {
                    if (L != i && R != i) {
                        ans++;
                        break;
                    } else if (L == i) {
                        L++;
                    } else {
                        R--;
                    }
                } else if (sum > k) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}
