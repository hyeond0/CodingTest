import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int L = 0, R = people.length-1, answer = 0;
        while (L < R) {
            if (people[L] + people[R] > limit) {
                answer++;
                R--;
            } else {
                L++;
                R--;
                answer++;
            }
        }
        if (L == R) answer++;
        return answer;
    }
}