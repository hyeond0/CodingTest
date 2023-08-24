import java.util.*;
import java.io.*;

public class Main {
    static String[] map = new String[5];
    static int[][] choiceMap = new int[5][5];
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
        if (k == 8) { // 1 - 25 중 7개를 뽑았다면
            int[] index = findIndex(); // 7개 숫자를 map 인덱스로 찾아가 choiceMap에 선택 처리
            bfs(index[0], index[1]); // 맨 처음 선택된 숫자로 bfs 탐색 시작
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
        int sCount = 0; // 7개 정점 중 이다솜파 카운트
        int linkCount = 1; // 7개 정점이 간선으로 연결되어 있는지 카운트

        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        choiceMap[x][y] = 1; // 뽑힌 7개 정점 중에서도 탐색을 한 정점은 1
        if (map[x].charAt(y) == 'S') sCount++; // 이다솜파인지 확인

        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) { // 격자형 그래프 간선 확인
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue; // map 밖으로 나가는지
                if (choiceMap[nx][ny] != 0) continue; // 뽑은 7개가 아니거나 이미 탐색을 했는지
                Q.add(nx);
                Q.add(ny);
                linkCount++;
                choiceMap[nx][ny] = 1; // 탐색 여부 체크
                if (map[nx].charAt(ny) == 'S') sCount++; // 이다솜파인지 확인
            }
        }
        // 탐색이 끝난 뒤 7개 정점이 연결되어있고, 이다솜파가 4명 이상이라면
        if (linkCount == 7 && sCount >= 4) answer++;
    }

    private static int[] findIndex() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                choiceMap[i][j] = -1; // choiceMap 초기화
            }
        }

        int[] ret = new int[2];
        // 1 - 25 까지 중에서 뽑아온 7개를 2차원 배열 index에 맞게 저장.
        for (int i = 1; i <= 7; i++) {
            int selectedNumber = selected[i];
            int x = (selectedNumber - 1) / 5;
            int y = (selectedNumber - 1) % 5;
            if (i == 1) {
                ret[0] = x; // bfs 탐색을 위해 7개 중 맨 처음 뽑힌 정점 좌표를 x, y로 저장
                ret[1] = y;
            }
            choiceMap[x][y] = 0; // 뽑아온 7개는 0, 나머지는 -1로 탐색 시작
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        input();
        // 백트래킹을 통해 숫자 1 - 25 중 7개 뽑아서 bfs 돌리기
        ref_func(1);
        // 칠공주 결성 경우의 수 출력
        System.out.println(answer);
    }
}