import java.util.*;
class Solution {
    static boolean[] students;
    public int solution(int n, int[] lost, int[] reserve) {
        students = new boolean[n+1];
        List<Integer> reserveList = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            students[i] = true;
        }
    
        for (int l : lost) {
            students[l] = false;
        }
    
        for (int r : reserve) {
            if (!students[r]) {
                students[r] = true;
                continue;
            }
            reserveList.add(r);
        }
        Collections.sort(reserveList);
        for (int r : reserveList) {
            if (!students[r-1] && r-1 != 0) {
                students[r-1] = true;
                continue;
            }
            if (r + 1 < students.length && !students[r+1]) {
                students[r+1] = true;
            }
        }
        int answer = 0;
        for (int i = 1; i < students.length; i++) {
            System.out.print(students[i] + " ");
            if (students[i]) {
                answer++;
            }
        }
        return answer;
    }
}