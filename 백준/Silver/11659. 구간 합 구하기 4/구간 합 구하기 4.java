import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        String input[] = br.readLine().split(" "); // 공백을 기준으로 나누기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int A[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int S[] = new int[n];
        S[0] = A[0];
        for (int i = 1; i < n; i++) {
            S[i] = S[i - 1] + A[i];
        }

        for (int i =0; i < m; i++) { // M번만큼 반복
            st = new StringTokenizer(br.readLine()); // 인덱스는 0번부터 시작하므로 -1
            int start = Integer.parseInt(st.nextToken()) - 1 ;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if (start == 0) { // 첫 번째 수부터의 합 배열일 경우
                System.out.println(S[end]);
            }
            else {
                System.out.println(S[end] - S[start - 1]);
            }
        }
    }
}