import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int n, find, x, y, up, down, left, right, currentValue;
    static int[][] A;

    static void input() {
        n = scan.nextInt();
        find = scan.nextInt();
        A = new int[n + 1][n + 1];
    }

    static void process() {
        // 중점 x, y 설정
        x = n / 2 + 1;
        y = n / 2 + 1;
        // 상하좌우 설정
        right = 1;
        down = 2;
        left = 2;
        up = 2;
        // currentValue 설정
        currentValue = 1;
        A[x][y] = currentValue++;
        while (x > 1 && y > 1) {
            moveUpOne();
            moveRight();
            moveDown();
            moveLeft();
            moveUp();
            updateDirection();
        }
        // 배열 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int value = A[i][j];
                sb.append(value).append(' ');
                if (value == find) {
                    x = i;
                    y = j;
                }
            }
            sb.append("\n");
        }
        sb.append(x).append(' ').append(y);
        System.out.println(sb.toString());
    }

    private static void updateDirection() {
        up += 2;
        down += 2;
        right += 2;
        left += 2;
    }

    private static void moveUp() {
        for (int i = 0; i < up; i++) {
            x--;
            A[x][y] = currentValue++;
        }
    }

    private static void moveLeft() {
        for (int i = 0; i < left; i++) {
            y--;
            A[x][y] = currentValue++;
        }
    }

    private static void moveDown() {
        for (int i = 0; i < down; i++) {
            x++;
            A[x][y] = currentValue++;
        }
    }

    private static void moveRight() {
        for (int i = 0; i < right; i++) {
            y++;
            A[x][y] = currentValue++;
        }
    }

    private static void moveUpOne() {
        x--;
        A[x][y] = currentValue++;
    }

    public static void main(String[] args) {
        input();
        process();
    }
}