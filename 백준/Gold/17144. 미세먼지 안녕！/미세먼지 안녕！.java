import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M, T;
    static int[][] A, B;
    static int[][] map;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Scanner scan = new Scanner(System.in);

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        T = scan.nextInt();
        map = new int[N][M];
        A = new int[N][M];
        B = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scan.nextInt();
            }
        }
    }

    static void process() {
        while (T > 0) {
            // 1. 미세먼지 확산
            // 인접한 방향에 공기청정기 있으면 확산 x
            int airCleanerUp = 0;
            int airCleanerDown = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][0] == -1 && map[i + 1][0] == -1) {
                    airCleanerUp = i;
                    airCleanerDown = i + 1;
                    A[airCleanerUp][0] = -1;
                    A[airCleanerDown][0] = -1;
                }
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        int hCount = 0;
                        Queue<Integer> Q = new LinkedList<>();
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dir[k][0];
                            int ny = j + dir[k][1];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                                continue;
                            }
                            if (map[nx][ny] == -1) {
                                continue;
                            }
                            hCount++;
                            Q.add(nx);
                            Q.add(ny);
                        }
                        while (!Q.isEmpty()) {
                            int x = Q.poll();
                            int y = Q.poll();
                            A[x][y] += map[i][j] / 5;
                        }
                        A[i][j] += map[i][j] - ((map[i][j] / 5) * hCount);
                    }
                }
            }
            // 2. 공기청정기 작동

            //공기청정기 -> 맨 위 천장
            for (int i = airCleanerUp - 1; i > 0; i--) {
                A[i][0] = A[i - 1][0];
            }
            // 맨 윗줄 <------
            for (int i = 0; i < M - 1; i++) {
                A[0][i] = A[0][i + 1];
            }
            // 맨 오른쪽 라인 위로 올라가는 순환
            for (int i = 0; i < airCleanerUp; i++) {
                A[i][M - 1] = A[i + 1][M - 1];
            }
            for (int i = M - 1; i > 1; i--) {
                A[airCleanerUp][i] = A[airCleanerUp][i - 1];
            }
            A[airCleanerUp][1] = 0;

            // down
            for (int i = airCleanerDown + 1; i < N - 1; i++) {
                A[i][0] = A[i + 1][0];
            }

            for (int i = 0; i < M - 1; i++) {
                A[N - 1][i] = A[N - 1][i + 1];
            }

            for (int i = N - 1; i > airCleanerDown; i--) {
                A[i][M - 1] = A[i - 1][M - 1];
            }

            for (int i = M - 1; i > 1; i--) {
                A[airCleanerDown][i] = A[airCleanerDown][i - 1];
            }
            A[airCleanerDown][1] = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = A[i][j];
                    A[i][j] = 0;
                }
            }
            T--;
        }
        int count = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                count += map[i][j];
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
