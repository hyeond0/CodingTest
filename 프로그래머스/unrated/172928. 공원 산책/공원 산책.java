class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] dirAlpha = {'N', 'E', 'S', 'W'};
        int d = 1;
        int x = 0, y = 0;
        int W = park.length;
        int H = park[0].length();
        char[][] map = new char[W][H];
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String moveDirection = routes[i].split(" ")[0];
            String moveDistance = routes[i].split(" ")[1];
            for (int j = 0; j < dirAlpha.length; j++) {
                if (dirAlpha[j] == moveDirection.charAt(0)) {
                    d = j;
                }
            }
            
            boolean isPossible = true;
            for (int k = 0; k < Integer.parseInt(moveDistance); k++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];
                if (nx < 0 || ny < 0 || nx >= W || ny >= H) isPossible = false;
                if (!isPossible || map[nx][ny] == 'X') isPossible = false;
                x = nx;
                y = ny;
                if (!isPossible) {
                    x = x - (dir[d][0] * (k+1));
                    y = y - (dir[d][1] * (k+1));
                    break;
                }
            }
        }
        int[] answer = {x, y};
        return answer;
    }
}