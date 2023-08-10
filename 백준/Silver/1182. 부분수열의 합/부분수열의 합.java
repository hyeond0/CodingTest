import java.util.*;
import java.io.*;

public class Main {
    static int N, S, ans;
    static int[] numArray;

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1, 0);
        if (S==0) ans--;
        System.out.println(ans);
    }

    private static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (value == S) ans++;
        } else {
            // 포함 할지
            rec_func(k+1, value + numArray[k]);
            //포함 안 할지
            rec_func(k+1, value);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numArray = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }
    }
}