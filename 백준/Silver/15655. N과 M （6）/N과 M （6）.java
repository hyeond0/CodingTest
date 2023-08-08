import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] selected;
    static ArrayList<Integer> num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
        num = new ArrayList<>();
        num.add(0);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(num);
        rec_func(1);
        System.out.println(sb.toString());
    }

    private static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            int start = num.indexOf(selected[k-1]);
            if (start==-1) start = 1;
            for (int cand = start; cand <= N; cand++) {
                boolean isUsed = false;
                for (int i = 1; i <= k; i++) {
                    if (selected[i] == num.get(cand)) isUsed = true;
                }
                if (!isUsed) {
                    selected[k] = num.get(cand);
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }
}