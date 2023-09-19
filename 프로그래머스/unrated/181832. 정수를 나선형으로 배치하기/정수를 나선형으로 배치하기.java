class Solution {
    public int[][] solution(int n) {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0,-1}};
        int[][] answer = new int[n][n];
        int d = 1, num = 1, x = 0, y = 0;
        boolean rotate = false;
        answer[x][y] = num;
        num++;
        while (num <= n*n) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) rotate = true;
            if (rotate || answer[nx][ny] > 0) rotate = true;
            if (rotate) {
                d = (d+1) % 4;
                rotate = false;
            } else {
                x = nx;
                y = ny;
                answer[x][y] = num;
                num++;
            }
        }
        return answer;
    }
}