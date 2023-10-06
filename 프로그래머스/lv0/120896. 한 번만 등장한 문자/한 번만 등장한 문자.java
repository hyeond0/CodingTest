import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (char c : hashMap.keySet()) {
            if (hashMap.get(c) == 1) {
                list.add(c);
            }
        }
        Collections.sort(list);
        for (char st : list) {
            sb.append(st);
        }
        return sb.toString();
    }
}