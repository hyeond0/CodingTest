import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0,-1}};
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        Q.add(0);
        dist[0][0] = 1;
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0) continue;
                if (dist[nx][ny] != -1) continue;
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
        return dist[n-1][m-1];
    }
}