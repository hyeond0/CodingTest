class Solution {
    static int N, answer, max;
    static int[] selected;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        max = k;
        answer = Integer.MIN_VALUE;
        selected = new int[N+1];
        rec_func(1, dungeons);
        return answer;
    }
    
    static void rec_func(int k, int[][] dungeons) {
        if (k == N+1) {
            answer = Math.max(answer, calc_piro(dungeons));
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean isUsed = false;
                for (int i = 1; i < k; i++) {
                    if (selected[i] == cand) isUsed = true;
                }
                if (!isUsed) {
                    selected[k] = cand;
                    rec_func(k+1, dungeons);
                    selected[k] = 0;
                }
            }
        }
    }
    static int calc_piro(int[][] dungeons) {
        int m = max;
        int idx = 0;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            idx = selected[i] - 1;
            if (m < dungeons[idx][0]) return count;
            if (m - dungeons[idx][1] < 0) return count;
            m -= dungeons[idx][1];
            count++;
        }
        return count;
    }
}