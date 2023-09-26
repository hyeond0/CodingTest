import java.util.*;
class Solution {
    int count, n, m;
    boolean[][] visit;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        ArrayList<Integer> list = new ArrayList<>();
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visit[i][j]) {
                    count = 0;
                    dfs(i, j, maps);
                    list.add(count);
                }
            }
        }
        int[] answer;
        if (!list.isEmpty()) {
            Collections.sort(list);
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        } else {
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
    
    public void dfs(int x, int y, String[] maps) {
        visit[x][y] = true;
        count += maps[x].charAt(y) - '0';
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visit[nx][ny]) continue;
            if (maps[nx].charAt(ny) == 'X') continue;
            dfs(nx, ny, maps);
        }
    }
}