import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> group;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = scan.next();
            String[] sArray = s.split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(sArray[j]);
            }
        }
        visited = new boolean[N][N];
    }

    static void dfs(int x, int y) {
        // 단지에 속한 집의 갯수 증가, visit 체크하기
        group.set(group.size()-1, group.get(group.size()-1) + 1);
        visited[x][y] = true;
        //인접한 집으로 새로운 방문하기
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < N && nx >= 0 && ny < N && ny >= 0) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void pro() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    group.add(0);
                    dfs(i,j);
                }
            }
        }

        System.out.println(group.size());
        Collections.sort(group);
        for (int s : group) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}