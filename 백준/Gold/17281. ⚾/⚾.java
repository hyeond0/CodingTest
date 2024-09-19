import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] players;
    static int[] selected;
    static boolean[] isUsed;
    static boolean[] base = new boolean[3];
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(ans);
    }

    static void input() {
        n = scan.nextInt();
        selected = new int[10];
        isUsed = new boolean[10];
        players = new int[n + 1][10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 9; j++) {
                players[i][j] = scan.nextInt();
            }
        }
        isUsed[1] = true;
        selected[4] = 1;
    }

    static void rec_func(int k) {
        if (k == 10) {
            int score = 0;
            int idx = 1;
            int innings = 1;
            int out_count = 0;
            while (innings <= n) {
                Arrays.fill(base, false);
                int[] player = players[innings];
                while (out_count < 3) {
                    int hit = player[selected[idx]];
                    switch (hit) {
                        case 0:
                            out_count++;
                            break;
                        case 1:
                            if (base[2]) {
                                score++;
                                base[2] = false;
                            }
                            if (base[1]) {
                                base[2] = true;
                                base[1] = false;
                            }
                            if (base[0]) {
                                base[1] = true;
                                base[0] = false;
                            }
                            base[0] = true;
                            break;
                        case 2:
                            if (base[2]) {
                                score++;
                                base[2] = false;
                            }
                            if (base[1]) {
                                score++;
                                base[1] = false;
                            }
                            if (base[0]) {
                                base[2] = true;
                                base[0] = false;
                            }
                            base[1] = true;
                            break;
                        case 3:
                            if (base[2]) {
                                score++;
                                base[2] = false;
                            }
                            if (base[1]) {
                                score++;
                                base[1] = false;
                            }
                            if (base[0]) {
                                score++;
                                base[0] = false;
                            }
                            base[2] = true;
                            break;
                        case 4:
                            if (base[2]) {
                                score++;
                                base[2] = false;
                            }
                            if (base[1]) {
                                score++;
                                base[1] = false;
                            }
                            if (base[0]) {
                                score++;
                                base[0] = false;
                            }
                            score++;
                            break;
                    }
                    if (idx == 9) {
                        idx = 1;
                    } else {
                        idx++;
                    }
                }
                out_count = 0;
                innings++;
            }
            ans = Math.max(ans, score);
            return;
        }
        if (k == 4) {
            selected[k] = 1;
            rec_func(k + 1);
        }
        for (int i = 2; i <= 9; i++) {
            if (!isUsed[i]) {
                selected[k] = i;
                isUsed[i] = true;
                rec_func(k + 1);
                isUsed[i] = false;
            }
        }
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
