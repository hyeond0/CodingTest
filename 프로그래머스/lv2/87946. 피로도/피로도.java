class Solution {

    int answer, dungeon;
    int[] selected;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        dungeon = dungeons.length;
        for (int i = 1; i <= dungeon; i++) {
            selected = new int[i];
            ref_func(0, k, dungeons, i);
        }
        return answer;
    }

    public void ref_func(int n, int k, int[][] dungeons, int select) {
        if (n == select) {
            int count = 0;
            int presentPiro = k;
            for (int i = 0; i < select; i++) {
                int minPiro = dungeons[selected[i]][0];
                int usePiro = dungeons[selected[i]][1];
                if (minPiro > presentPiro) {
                    return;
                }
                presentPiro -= usePiro;
                count++;
            }
            answer = Math.max(answer, count);
        } else {
            for (int cand = 0; cand < dungeon; cand++) {
                boolean isUsed = false;
                for (int i = 0; i < n; i++) {
                    if (cand == selected[i]) {
                        isUsed = true;
                    }
                }
                if (!isUsed) {
                    selected[n] = cand;
                    ref_func(n + 1, k, dungeons, select);
                    selected[n] = 0;
                }
            }
        }
    }
}