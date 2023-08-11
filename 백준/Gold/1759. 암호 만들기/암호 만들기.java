import java.util.*;
import java.io.*;

public class Main {
    static int L, C;
    static int[] selected;
    static char[] alphabet;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        ref_func(1);
        System.out.println(sb.toString());
    }

    private static void ref_func(int k) {
        if (k == L + 1) {
            boolean isRight = checkPassword();
        }
        else {
            int start = selected[k-1];
            for (int cand = start+1; cand <= C; cand++) {
                boolean isUsed = false;
                for (int i = 1; i < k; i++) {
                    if (selected[i] == cand) isUsed = true;
                }
                if(!isUsed) {
                    selected[k] = cand;
                    ref_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    private static boolean checkPassword() {
        StringBuilder temp = new StringBuilder();
        int moCount = 0;
        for (int i = 1; i <= L; i++) {
            char alpha = alphabet[selected[i]];
            temp.append(alpha);
            if (alpha == 'a' || alpha == 'e' || alpha == 'i' || alpha == 'o' || alpha == 'u') {
                moCount++;
            }
        }
        if (moCount < L-1 && moCount != 0) {
            sb.append(temp);
            sb.append('\n');
            return true;
        }
        else return false;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        selected = new int[L+1];
        alphabet = new char[C+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);
    }
}