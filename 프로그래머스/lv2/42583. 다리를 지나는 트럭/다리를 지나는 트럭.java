import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> waitTruck = new LinkedList<>(); // 대기 트럭 큐 생성
        for (int truck : truck_weights) {
            waitTruck.add(truck);
        }
        
        int present_weight = 0;
        int answer = 0;
        
        ArrayList<Integer> timeList = new ArrayList<>(); // 각 트럭 별 다리 건너는 시간 계산 리스트

        Queue<Integer> bridgeTruck = new LinkedList<>(); // 다리를 건너는 트럭 큐 생성

        while(!waitTruck.isEmpty() || !bridgeTruck.isEmpty()) { // 다리를 건너는 트럭이나 대기 트럭이 있다면
            if (!bridgeTruck.isEmpty()) { // 다리를 건너는 트럭이 있다면
                if (timeList.get(0) == bridge_length) { // 맨 앞 트럭이 다리를 다 건넜다면
                    present_weight -= bridgeTruck.poll(); // 현재 다리 무게 - 맨 앞 트럭 무게
                    timeList.remove(0);
                }
            }

            if (!waitTruck.isEmpty()) { // 대기 중인 트럭이 있다면
                if (present_weight + waitTruck.peek() <= weight && timeList.size() < bridge_length) {
                    // 다리를 건널 수 있는 조건
                    // 1. 현재 무게 + 대기 트럭이 다리가 견딜 수 있는 무게보다 같거나 적을 때
                    // 2. 다리에 최대 올라올 수 있는 트럭 수보다 올라와 있는 트럭 수가 적을 때
                    int truckWeight = waitTruck.poll();
                    bridgeTruck.add(truckWeight); // 대기 트럭 -> 다리를 건너는 트럭
                    timeList.add(0);
                    present_weight += truckWeight;  // 트럭 무게 추가
                }
            }

            if (!timeList.isEmpty()) {
                // 다리를 건너는 트럭이 있다면 1초 증가
                for (int i = 0; i < timeList.size(); i++) {
                    timeList.set(i, timeList.get(i)+1);
                }
            }
            // 1초 증가
            answer += 1;
        }
        return answer;
    }
}