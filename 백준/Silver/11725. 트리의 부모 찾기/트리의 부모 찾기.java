
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static void input() {
        n = scan.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        parent = new int[n + 1];
    }

    // dfs(x, par) := 정점 x 의 부모가 par 였고, x의 children들을 찾아주는 함수
    static void dfs(int x, int par) {
        for (int y : adj[x]) {
            if (y == par) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }

    static void pro() {
        // 1 번 정점이 ROOT 이므로, 여기서 시작해서 Tree의 구조를 파악하자.
        dfs(1, 1);

        // 정답 출력하기
        /* TODO */
        for (int i = 2; i <= n; i++) sb.append(parent[i]).append('\n');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}