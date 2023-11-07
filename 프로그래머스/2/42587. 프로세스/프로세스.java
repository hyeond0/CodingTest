import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> Q = new LinkedList<>();
        Queue<Process> priorityQ = new PriorityQueue<>((o1, o2) -> o2.priority - o1.priority);
        for (int i = 0; i < priorities.length; i++) {
            Q.add(new Process(i, priorities[i]));
            priorityQ.add(new Process(i, priorities[i]));
        }
        
        int answer = 0;
        while (!Q.isEmpty()) {
            Process pro = Q.poll();
            if (priorityQ.peek().priority != pro.priority) {
                Q.add(pro);
            } else {
                answer++;
                priorityQ.poll();
                if (pro.location == location) {
                    break;
                }
            }
        }
        return answer;
    }
    
    public class Process {
        int location;
        int priority;
        
        public Process(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
}