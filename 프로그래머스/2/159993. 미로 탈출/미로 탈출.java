import java.util.*;
class Solution {
    static int n, m;
    static char[][] map;
    static int[][] dist;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int solution(String[] maps) {
        // map에 집어넣기
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] c = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = c[j];
                dist[i][j] = -1;
            }
        }
        
        // S 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    dist[i][j] = 0;
                    bfs(i, j);
                }
            }
        }
        int leverX = 0, leverY = 0, lever = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    if (dist[i][j] == -1) return -1;
                    leverX = i;
                    leverY = j;
                    lever = dist[i][j];
                }
                dist[i][j] = -1;
            }
        }
        
        // dist 초기화, lever 위치 구했으니 다시 bfs
        dist[leverX][leverY] = lever;
        bfs(leverX, leverY);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'E') {
                    if (dist[i][j] == -1) return -1;
                    return dist[i][j];
                }
            }
        }
        
        return -1;
    }
    static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 'X') continue;
                if (dist[nx][ny] != -1) continue;
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }
}