import java.util.*;
class Solution {
    static char[][] map;
    static int[][] dist;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static boolean isSave;
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        int idx = 0;
        for (String[] place : places) {
            // 맵을 만들기
            map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                char[] cArray = place[i].toCharArray();
                for (int j = 0; j < 5; j++) {
                    map[i][j] = cArray[j];
                }
            }
            
            isSave = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == 'P') {
                        dist = new int[5][5];
                        bfs(i, j);
                    }
                }
            }
            if (isSave) result[idx++] = 1;
            else result[idx++] = 0;
        }
        return result;
    }
    
    static void bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 1;
        
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (map[nx][ny] == 'X') continue;
                if (dist[nx][ny] != 0) continue;
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
                if (map[nx][ny] == 'P' && dist[nx][ny] <= 3 && dist[nx][ny] != 0) {
                    isSave = false;
                    return;
                }
            }
        }
    }
}