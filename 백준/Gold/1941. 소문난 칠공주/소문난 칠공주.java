import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static String[] map = new String[5];

    static int[][] dist = new int[5][5];
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[] selected = new int[8];
    static int answer;
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine();
        }
    }
    private static void ref_func(int k) {
        if (k == 8) {
//            if (selected[1] == 6 && selected[2] == 7 && selected[3] == 8 && selected[4] == 9 && selected[5] == 10 && selected[6] == 15 && selected[7] == 20) {
//                int[] index = findIndex();
//                bfs(index[0], index[1]);
//            }
            int[] index = findIndex();
            bfs(index[0], index[1]);
        } else {
            int start = selected[k - 1];
            for (int cand = start+1; cand <= 25; cand++) {
                selected[k] = cand;
                ref_func(k+1);
                selected[k] = 0;
            }
        }

    }

    private static void bfs(int x, int y) {
        int countS = 0;
        int count = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 1;
        if (map[x].charAt(y) == 'S') countS++;
        count++;

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (dist[nx][ny] != 0) continue; // 뽑은 7개가 아니면 continue
                Q.add(nx);
                Q.add(ny);
                count++;
                dist[nx][ny] = 1;
                if (map[nx].charAt(ny) == 'S') countS++;
            }
        }

        if (count == 7 && countS >= 4) answer++;
    }

    private static int[] findIndex() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dist[i][j] = -1; // dist 초기화
            }
        }

        int[] ret = new int[2];
        for (int i = 1; i <= 7; i++) {
            int x = selected[i] / 5;
            int y;
            if (selected[i] % 5 == 0) {
                x -= 1;
                y = 4;
            }
            else y = selected[i] % 5 - 1;
            if (i == 1) {
                ret[0] = x;
                ret[1] = y;
            } else dist[x][y] = 0;
        }
        return ret;
    }

    private static void pro() {
        // dist 초기화

        // 백트래킹을 통해 숫자 7개 뽑기 1 - 25까지
        ref_func(1);
        // 7개를 뽑는다면 조건 확인 -> bfs 등등

        // 경우의 수 출력
        System.out.println(answer);
    }
}