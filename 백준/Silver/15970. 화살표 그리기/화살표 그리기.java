import java.util.*;

public class Main {
    static int total = 0;
    static int N;
    static ArrayList<Integer>[] a;

    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        a = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            a[y].add(x);
        }
    }

    private static void pro() {
        for (int i = 1; i <= N; i++) {
            Collections.sort(a[i]);
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < a[i].size(); j++) {
                if (j==0) total += a[i].get(j+1) - a[i].get(j);
                else if (j==a[i].size()-1) total += a[i].get(j) - a[i].get(j-1);
                else total += Math.min(a[i].get(j) - a[i].get(j-1), a[i].get(j+1) - a[i].get(j));
            }
        }

        System.out.println(total);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}