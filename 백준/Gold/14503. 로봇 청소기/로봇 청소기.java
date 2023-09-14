import java.util.Scanner;

public class Main {

    static int N, M, d, robotX, robotY;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        input();
        process();
    }

    private static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        robotX = scan.nextInt();
        robotY = scan.nextInt();
        d = scan.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    private static void process() {
        int answer = 0;
        // 작동 시작
        while (true) {
            //1번
            if (map[robotX][robotY] == 0) {
                map[robotX][robotY] = 2;
                answer++;
            }
            // 주변 4칸 중 빈칸 체크
            boolean isPossible = false;
            for (int k = 0; k < 4; k++) {
                int nx = robotX + dir[k][0];
                int ny = robotY + dir[k][1];
                if (map[nx][ny] == 0) {
                    isPossible = true;
                }
            }
            //3 - 빈칸이 있는 경우
            if (isPossible) {
                int ccw = 0;
                if (d == 0) {
                    ccw = 3;
                }
                if (d == 1) {
                    ccw = 0;
                }
                if (d == 2) {
                    ccw = 1;
                }
                if (d == 3) {
                    ccw = 2;
                }
                d = ccw; // 반시계 90도 회전
                int nx = robotX + dir[d][0];
                int ny = robotY + dir[d][1];
                if (map[nx][ny] == 0) {
                    // 3-2, 빈칸일 경우 한 칸 전진
                    robotX = nx;
                    robotY = ny;
                }
            } else {
                // 2. 빈 칸이 없는 경우
                int back = 0;
                if (d == 0) {
                    // 남쪽
                    back = 2;
                }
                if (d == 1) {
                    // 서쪽
                    back = 3;
                }
                if (d == 2) {
                    // 북족
                    back = 0;
                }
                if (d == 3) {
                    // 동쪽
                    back = 1;
                }
                int nx = robotX + dir[back][0];
                int ny = robotY + dir[back][1];
                // 후진할 수 없다면 break
                if (nx < 0 || ny < 0 || nx > N || ny > M) {
                    break;
                }
                if (map[nx][ny] == 1) {
                    break;
                }
                // 후진할 수 있다면
                robotX = nx;
                robotY = ny;
            }
        }
        System.out.println(answer);
    }
}
