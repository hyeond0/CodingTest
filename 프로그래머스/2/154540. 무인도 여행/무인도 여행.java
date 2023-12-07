import java.util.*;
class Solution {
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {0, -1}, {1,0}, {0, 1}};
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] s = maps[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (s[j] == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = s[j] - '0';
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }
        if (result.isEmpty()) {
            int[] ans = new int[1];
            ans[0] = -1;
            return ans;
        }
        
        
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    static int bfs(int x, int y) {
        int sum = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        visited[x][y] = true;
        sum += map[x][y];
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;
                Q.add(nx);
                Q.add(ny);
                visited[nx][ny] = true;
                sum += map[nx][ny];
            }
        }
        
        System.out.println(sum);
        return sum;
    }
}