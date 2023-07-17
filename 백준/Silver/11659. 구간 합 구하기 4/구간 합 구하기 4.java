import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" "); // 공백을 기준으로 나누기
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int A[] = new int[n];
        String array[] = br.readLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            A[i] = Integer.parseInt(array[i]);
        }
        int S[] = new int[n];
        S[0] = A[0];
        for (int i = 1; i < n; i++) {
            S[i] = S[i - 1] + A[i];
        }

        for (int i =0; i < m; i++) { // M번만큼 반복
            String section[] = br.readLine().split(" "); // 인덱스는 0번부터 시작하므로 -1
            int start = Integer.parseInt(section[0]) - 1 ;
            int end = Integer.parseInt(section[1]) - 1;
            if (start == 0) { // 첫 번째 수부터의 합 배열일 경우
                System.out.println(S[end]);
            }
            else {
                System.out.println(S[end] - S[start - 1]);
            }
        }
    }
}