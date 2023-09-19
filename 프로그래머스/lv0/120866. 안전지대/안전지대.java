class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] danger = new boolean[n][n]; 
        int[][] dir = {{-1, -1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    danger[i][j] = true;
                    for (int k = 0; k<8; k++) {
                        int nx = i + dir[k][0];
                        int ny = j + dir[k][1];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        danger[nx][ny] = true;
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < n; j++) {
                if (!danger[i][j]) answer++;
            }
        }
        return answer;
    }
}