import java.util.*;
class Solution {
    class Info {
        int num, rank;
        boolean att;
        public Info(int num, int rank, boolean att) {
            this.num = num;
            this.rank = rank;
            this.att = att;
        }
    }
    
    public int solution(int[] rank, boolean[] attendance) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.rank));
        
        for (int i = 0; i < rank.length; i++) {
            pq.add(new Info(i, rank[i], attendance[i]));
        }
        
        int count = 0;
        int[] topThree = new int[3];
        while (count < 3) {
            Info info = pq.poll();
            if (info.att) {
                topThree[count] = info.num;
                count++;
            }
        }
        return 10000 * topThree[0] + 100 * topThree[1] + topThree[2];
    }
}