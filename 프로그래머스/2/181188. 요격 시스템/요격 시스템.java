import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Missile[] a = new Missile[targets.length];
        for (int i = 0; i < targets.length; i++) {
            a[i] = new Missile(targets[i][0], targets[i][1]);
        }
        
        Arrays.sort(a);
        int start = a[0].s, end = a[0].e, answer = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i].e <= start) {
                answer++;
                start = a[i].s;
                end = a[i].e;
                continue;
            }
            
            if (a[i].s > start) {
                start = a[i].s;
            }
            if (a[i].e < end) {
                end = a[i].e;
            }
        }
        answer++;
        return answer;
    }

    public class Missile implements Comparable<Missile>{
        private int s;
        private int e;

        public Missile(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        public int compareTo(Missile other) {
            if (e == other.e) return other.s - s;
            return other.e - e;
        }
    }
}