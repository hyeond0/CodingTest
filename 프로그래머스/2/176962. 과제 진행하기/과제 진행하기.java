import java.util.*;
class Solution {
    static Plan[] a;
    public String[] solution(String[][] plans) {
        a = new Plan[plans.length];
        String[] answer = new String[plans.length];
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int hours = Integer.parseInt(plans[i][1].split(":")[0]) * 60;
            int minutes = Integer.parseInt(plans[i][1].split(":")[1]);
            int time = hours + minutes;
            int playTime = Integer.parseInt(plans[i][2]);
            a[i] = new Plan(name, time, playTime);
        }
        
        // 시간 순서대로 정렬
        Arrays.sort(a);
        
        // 과제 시작
        int order = 0;
        Stack<Plan> Q = new Stack<>();
        int now = 0;
        for (int i = 0; i < a.length; i++) {

            // 과제 시작
            Plan p = a[i];
            // 마지막 과제라면
            if (i == a.length - 1) {
                answer[order++] = p.name;
                now += p.playTime;
                continue;
            }
            
            Plan nextP = a[i+1];
            now = p.start;

            if (p.start + p.playTime <= nextP.start) {
                answer[order++] = a[i].name;
                now += p.playTime;
                // 남은 시작시간까지 다음 과제
                while(!Q.isEmpty()) {
                    Plan another = Q.pop();
                    // 다음 과제 시작 전에 끝나면 answer에 추가
                    if (now + another.playTime <= nextP.start) {
                        answer[order++] = another.name;
                        now += another.playTime;
                    } else {
                        // 아니면 남은시간 차감 후 다시 Q에 넣기
                        Plan rest = new Plan(another.name, another.playTime - (nextP.start - now));
                        System.out.println(now + " " + nextP.start + " " + rest.name + " " + rest.playTime);
                        Q.add(rest);
                        break;
                    }
                }
            } else {
                Plan rest = new Plan(p.name, p.playTime - (nextP.start - p.start));
                System.out.println(rest.name + " " + rest.playTime);
                Q.add(rest);
            }
            
        }
        
        while (!Q.isEmpty()) {
            answer[order++] = Q.pop().name;
        }
        
        
        return answer;
    }
    
    static class Plan implements Comparable<Plan> {
        private String name;
        private int start;
        private int playTime;
        
        public Plan(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
        
        public Plan(String name, int playTime) {
            this.name = name;
            this.playTime = playTime;
        }
        
        @Override
        public int compareTo(Plan other) {
            return start - other.start;
        }
    }
}