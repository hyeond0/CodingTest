import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int temp[] = new int[N];
        int S[] = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        S[0] = temp[0];
        for (int i=1; i < N; i++) {
            S[i] = S[i-1] + temp[i]; // 합 배열
        }
        
        int max = -101 * K;
        int sum = 0;
        
        for (int i = K - 1; i < N; i++) {
                int j = i - (K - 1);
                if (j==0) sum = S[i];
                else sum = S[i] - S[j-1];
                if (sum > max) max = sum;
        }
        System.out.println(max);
    }
}