import java.util.*;
class Solution {
    static Tang[] a;
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int t : tangerine) {
            hashMap.put(t, hashMap.getOrDefault(t, 0) + 1);
        }
        a = new Tang[hashMap.size()];
        int index = 0;
        for (int key : hashMap.keySet()) {
            a[index++] = new Tang(key, hashMap.get(key));
        }
        Arrays.sort(a);
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            k -= a[i].value;
            answer++;
            if (k <= 0) break;
        }
        return answer;
    }
    
    static class Tang implements Comparable<Tang> {
        private int key;
        private int value;
        
        public Tang(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public int compareTo(Tang other) {
            return other.value - value;
        }
    }
}