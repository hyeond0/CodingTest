import java.util.*;
class Solution {
    int answer, dungeon;
    int[] selected;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        dungeon = dungeons.length;
        int[][] dArray = new int[dungeon+1][2];
        for (int i = 1; i <= dungeon; i++) {
            dArray[i][0] = dungeons[i-1][0];
            dArray[i][1] = dungeons[i-1][1];
        }
        for (int i = 1; i <= dungeon; i++) {
            selected = new int[i+1];
            ref_func(1, k, dArray, i);
        }
        return answer;
    }

    public void ref_func(int n, int k, int[][] dungeons, int select) {
        if (n == select+1) {
            int count = 0;
            int presentPiro = k;
            for (int i = 1; i <= select; i++) {
                int minPiro = dungeons[selected[i]][0];
                int usePiro = dungeons[selected[i]][1];
                if (minPiro > presentPiro) return;
                presentPiro -= usePiro;
                count++;
            }
            answer = Math.max(answer, count);
        } else {
            for (int cand = 1; cand <= dungeon; cand++) {
                boolean isUsed = false;
                for (int i=1;i<n;i++) {
                    if (cand == selected[i]) isUsed = true;
                }
                if (!isUsed) {
                    selected[n] = cand;
                    ref_func(n+1, k, dungeons, select);
                    selected[n] = 0;
                }
            }
        }
    }
}