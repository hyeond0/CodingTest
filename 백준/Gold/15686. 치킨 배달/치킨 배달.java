import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static int[][] board;
    static int[] selected;
    static List<Chicken> chickens = new ArrayList<>();
    static List<House> houses = new ArrayList<>();
    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        rec_func(0, 0);
        System.out.println(ans);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        board = new int[n][n];
        selected = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = scan.nextInt();
                if (num == 1) {
                    houses.add(new House(i, j));
                } else if (num == 2) {
                    chickens.add(new Chicken(i, j));
                }
                board[i][j] = num;
            }
        }
        ans = Integer.MAX_VALUE;
    }

    static void rec_func(int k, int st) {
        if (k == m) {
            ans = Math.min(ans, chicken_distance());
            return;
        }
        for (int i = st; i < chickens.size(); i++) {
            selected[k] = i;
            rec_func(k + 1, i + 1);
        }
    }

    static int chicken_distance() {
        // 각 집 별로 distance를 구해서 제일 가까운 치킨 거리들을 싹 구한다음
        // distance를 싹 합친다.
        int size = houses.size();
        int[] distance = new int[size];
        for (int i = 0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < size; i++) {
            House house = houses.get(i);
            for (int j = 0; j < m; j++) {
                Chicken chicken = chickens.get(selected[j]);
                int x_dist = Math.abs(chicken.x - house.x);
                int y_dist = Math.abs(chicken.y - house.y);
                distance[i] = Math.min(distance[i], x_dist + y_dist);
            }
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += distance[i];
        }
        return sum;
    }

    static class Chicken {
        int x;
        int y;

        Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class House {
        int x;
        int y;

        House(int x, int y) {
            this.x = x;
            this.y = y;
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
