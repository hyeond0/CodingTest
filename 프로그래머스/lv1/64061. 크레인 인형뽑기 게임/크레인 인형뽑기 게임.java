import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> crane = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move-1] != 0) {
                    int doll = board[i][move-1];
                    if (!crane.isEmpty()) {
                        if (crane.peek() == doll) {
                            crane.pop();
                            answer += 2;
                        } else {
                            crane.push(doll);
                        }
                    } else {
                        crane.push(doll);
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}