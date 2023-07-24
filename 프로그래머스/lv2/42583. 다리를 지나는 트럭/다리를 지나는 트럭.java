import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> waitTruck = new LinkedList<>();
        for (int truck : truck_weights) {
            waitTruck.add(truck);
        }
        
        int present_weight = 0;
        int answer = 0;
        ArrayList<Integer> timeList = new ArrayList<>();
        Queue<Integer> bridgeTruck = new LinkedList<>();
        
        while(!waitTruck.isEmpty() || !bridgeTruck.isEmpty()) { // 다리를 건너는 트럭이나 대기 트럭이 있다면
            if (!bridgeTruck.isEmpty()) {
                if (timeList.get(0) == bridge_length) {
                    present_weight -= bridgeTruck.poll();
                    timeList.remove(0);
                }
            }

            if (!waitTruck.isEmpty()) {
                if (present_weight + waitTruck.peek() <= weight && timeList.size() < bridge_length) {
                    int truckWeight = waitTruck.poll();
                    bridgeTruck.add(truckWeight);
                    timeList.add(0);
                    present_weight += truckWeight;
                }
            }
            if (!timeList.isEmpty()) {
                for (int i = 0; i < timeList.size(); i++) {
                    timeList.set(i, timeList.get(i)+1);
                }
            }
            answer += 1;
        }
        return answer;
    }
}