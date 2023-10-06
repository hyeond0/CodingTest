import java.util.*;
class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int a : array) {
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }
        int max = -1;
        int answer = -1;
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) > max) {
                answer = key;
                max = hashMap.get(key);
            }
        }
        int count = 0;
        for (int key : hashMap.keySet()) {
            if (hashMap.get(key) == max) {
                count++;
            }
        }
        if (count >= 2) return -1;
        return answer;
    }
}