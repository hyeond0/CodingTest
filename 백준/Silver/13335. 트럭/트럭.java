import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, w, l, ans;
    static Truck[] trucks;
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        pro();
    }

    static void input() {
        n = scan.nextInt();
        w = scan.nextInt();
        l = scan.nextInt();
        trucks = new Truck[n];
        for (int i = 0; i < n; i++) {
            trucks[i] = new Truck(scan.nextInt(), 0);
        }
    }

    static void pro() {
        int before = -1;
        int present = 0;
        int present_weight = 0;
        int time = 0;
        while (trucks[n - 1].move != -1) {
            for (int i = 0; i < n; i++) {
                if (trucks[i].move > 0) {
                    trucks[i].move++;
                    if (trucks[i].move > w) {
                        trucks[i].move = -1;
                        present_weight -= trucks[i].weight;
                    }
                }
            }
            if (present < n) {
                Truck truck = trucks[present];
                if (present_weight + truck.weight <= l) {
                    truck.move += 1;
                    present_weight += truck.weight;
                    present++;
                }
            }
            time++;
        }
        System.out.println(time);
    }


    static class Truck {
        int weight;
        int move;

        public Truck(int weight, int move) {
            this.weight = weight;
            this.move = move;
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
