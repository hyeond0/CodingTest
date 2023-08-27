import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    private static int bfs(int x) {
        // dist 초기화
        for (int i = 1; i <= N; i++) {
            dist[i] = 0;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);

        while (!Q.isEmpty()) {
            x = Q.poll();
            for (int y : adj[x]) {
                if (dist[y] != 0) continue;
                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        return sum;
    }

    private static void pro() {
        int minCount = Integer.MAX_VALUE;
        int kevinCount;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            kevinCount = bfs(i);
            if (kevinCount < minCount) {
                minCount = kevinCount;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
