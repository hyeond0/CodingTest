import java.util.*;
class Solution {
    static char[][] map;
    static int[][] dist;
    static int answer, N, M;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = board[i].toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
            }
        }
        dist = new int[N][M];
        // dist 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    // bfs 시작
                    answer = bfs(i, j);
                }
            }
        }
        
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j< M; j++) {
//                 System.out.print(dist[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        return answer;
    }
    
    static int bfs(int x, int y) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        dist[x][y] = 0;
        
        while (!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx += dir[k][0];
                    ny += dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        nx -= dir[k][0];
                        ny -= dir[k][1];
                        break;
                    }
                    if (map[nx][ny] == 'D') {
                        nx -= dir[k][0];
                        ny -= dir[k][1];
                        break;
                    }
                }
                //dist 업데이트
                if (map[nx][ny] == 'G') {
                    return dist[x][y] + 1;
                }
                if (dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[x][y] + 1;
                Q.add(nx);
                Q.add(ny);
            }
        }
       return -1;
    }
}