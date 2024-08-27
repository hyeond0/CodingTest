import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        char[] A = N.toCharArray();
        int[] B = new int[10];
        for (char a : A) {
            int num = a - '0';
            B[num]++;
        }
        int six = B[6], nine = B[9], max = 0, max_idx = 0;
        for (int i = 0; i < 10; i++) {
            if (B[i] > max) {
                max = B[i];
                max_idx = i;
            } else if (B[i] == max && i != 6 && i != 9) {
                max_idx = i;
            }
        }
        if (max_idx == 6 || max_idx == 9) {
            max = Math.round((float) (six + nine) / 2);
        }
        System.out.println(max);
    }
}
