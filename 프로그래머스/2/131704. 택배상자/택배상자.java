import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] mainBelt = new int[order.length + 1];
        for (int i = 1; i <= order.length; i++) mainBelt[i] = i;

        Stack<Integer> subBelt = new Stack<>();

        int mainIdx = 1;
        int orderIdx = 0;

        while (orderIdx < order.length) {
            int wantedBox = order[orderIdx];

            // 메인 벨트에 원하는 박스가 있는지 확인
            if (mainIdx <= order.length && mainBelt[mainIdx] == wantedBox) {
                answer++;
                mainIdx++;
                orderIdx++;
            } else {
                // 서브 벨트에 원하는 박스가 있는지 확인
                if (!subBelt.isEmpty() && subBelt.peek() == wantedBox) {
                    subBelt.pop();
                    answer++;
                    orderIdx++;
                } else {
                    // 메인 벨트에도 없고 서브 벨트에도 없으면 서브 벨트에 넣기
                    if (mainIdx <= order.length) {
                        subBelt.push(mainBelt[mainIdx]);
                        mainIdx++;
                    } else {
                        // 더 이상 메인 벨트에 박스가 없으면 종료
                        break;
                    }
                }
            }
        }

        return answer;
    }
}