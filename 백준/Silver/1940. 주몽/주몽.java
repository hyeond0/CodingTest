import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(A);

        int start_index = 0;
        int end_index = N-1;
        int sum = 0;
        int count = 0;
        while (start_index != end_index) {
            sum = A[start_index] + A[end_index];
            if (sum > M) {
                end_index--;
            } else if (sum < M) {
                start_index++;
            } else {
                end_index--;
                count++;
            }
        }
        System.out.println(count);
    }
}