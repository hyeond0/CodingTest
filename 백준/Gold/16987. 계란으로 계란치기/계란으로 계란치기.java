import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, count, max;
    static Egg[] arr;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(max);
    }

    static void input() {
        N = scan.nextInt();
        arr = new Egg[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Egg(scan.nextInt(), scan.nextInt());
        }
    }

    static void rec_func(int k) {
        if (k == N) {
            max = Math.max(max, count);
            return;
        }
        Egg hand = arr[k];
        if (hand.health <= 0 || count == N - 1) {
            rec_func(k + 1);
            return;
        }
        for (int i = 0; i < N; i++) {
            Egg egg = arr[i];
            if (i == k || egg.health <= 0) {
                continue;
            }
            break_egg(hand, arr[i]);
            rec_func(k + 1);
            recover_egg(hand, egg);
        }
    }

    static void recover_egg(Egg left, Egg right) {
        if (left.health <= 0) {
            count--;
        }
        if (right.health <= 0) {
            count--;
        }
        left.health += right.weight;
        right.health += left.weight;
    }

    static void break_egg(Egg left, Egg right) {
        left.health -= right.weight;
        right.health -= left.weight;
        if (left.health <= 0) {
            count++;
        }
        if (right.health <= 0) {
            count++;
        }
    }

    static class Egg {
        int health;
        int weight;

        public Egg(int health, int weight) {
            this.health = health;
            this.weight = weight;
        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

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
