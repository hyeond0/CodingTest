import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int min;
    static int[][][] board, new_board, dist;
    static boolean[] isUsed;
    static int[] selected, selected_dir;
    static FastReader scan = new FastReader();
    static int[][] dir = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) {
        input();
        rec_func(0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    static void input() {
        board = new int[5][5][5];
        new_board = new int[5][5][5];
        dist = new int[5][5][5];
        isUsed = new boolean[5];
        selected = new int[5];
        selected_dir = new int[5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[i][j][k] = scan.nextInt();
                }
            }
        }
        min = Integer.MAX_VALUE;
    }

    static void rec_dir(int k) {
        if (k == 5) {
            for (int i = 0; i < 5; i++) {
                int idx = selected[i];
                int dir = selected_dir[i];
                new_board[i] = rotate(idx, dir);
            }
            if (new_board[0][0][0] == 0 || new_board[4][4][4] == 0) {
                return;
            }
            bfs();
            if (dist[4][4][4] != -1) {
                min = Math.min(min, dist[4][4][4]);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            selected_dir[k] = i;
            rec_dir(k + 1);
        }
    }

    private static boolean isPossible() {
        int start = selected[0];
        int start_dir = selected_dir[0];
        int finish = selected[4];
        int finish_dir = selected_dir[4];
        int in = 0;
        int out = 0;
        switch (start_dir) {
            case 0:
                in = board[start][0][0];
                break;
            case 1:
                in = board[start][4][0];
                break;
            case 2:
                in = board[start][4][4];
                break;
            case 3:
                in = board[start][0][4];
                break;
        }
        switch (finish_dir) {
            case 0:
                out = board[finish][4][4];
                break;
            case 1:
                out = board[finish][0][4];
                break;
            case 2:
                out = board[finish][0][0];
                break;
            case 3:
                out = board[finish][4][0];
                break;
        }
        return in != 0 && out != 0;
    }

    private static void bfs() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(0, 0, 0));
        dist[0][0][0] = 0;

        while (!Q.isEmpty()) {
            Pair pair = Q.poll();
            for (int k = 0; k < 6; k++) {
                int nz = pair.z + dir[k][0];
                int nx = pair.x + dir[k][1];
                int ny = pair.y + dir[k][2];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= 5 || ny >= 5 || nz >= 5) {
                    continue;
                }
                if (dist[nz][nx][ny] != -1) {
                    continue;
                }
                if (new_board[nz][nx][ny] == 0) {
                    continue;
                }
                dist[nz][nx][ny] = dist[pair.z][pair.x][pair.y] + 1;
                Q.add(new Pair(nx, ny, nz));
            }
        }
    }

    static int[][] rotate(int idx, int dir) {
        int[][] result = new int[5][5];
        switch (dir) {
            case 0:
                return board[idx];
            case 1:
                result = rotate90(board[idx]);
                break;
            case 2:
                result = rotate90(rotate90(board[idx]));
                break;
            case 3:
                result = rotate90(rotate90(rotate90(board[idx])));
                break;
        }
        return result;
    }

    public static int[][] rotate90(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }


    static void rec_func(int k) {
        if (k == 5) {
            rec_dir(0);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!isUsed[i]) {
                selected[k] = i;
                isUsed[i] = true;
                rec_func(k + 1);
                isUsed[i] = false;
            }
        }
    }

    static class Pair {
        int x;
        int y;
        int z;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class FastReader {
        StringTokenizer st;
        BufferedReader br;

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
