class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length-1;
        if (sequence.length == 1) {
            answer[0] = sequence[0];
            answer[1] = sequence[1];
            return answer;
        }
        int L = 0, R = 0, sum = sequence[0];
        while (L <= R) {
            if (sum > k) {
                sum -= sequence[L];
                L++;
            } else if (sum < k) {
                R++;
                if (R >= sequence.length) {
                    break;
                }
                sum += sequence[R];
            } else {
                if (R - L < answer[1] - answer[0]) {
                    answer[0] = L;
                    answer[1] = R;
                } else if (R - L == answer[1] - answer[0]) {
                    if (L < answer[0]) {
                        answer[0] = L;
                        answer[1] = R;
                    }
                }
                R++;
                if (R >= sequence.length) {
                    break;
                }
                sum += sequence[R];
            }
        }
        return answer;
    }
}