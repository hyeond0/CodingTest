import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            hashMap.put(players[i], i);
        }
        for (String call : callings) {
            int index = hashMap.get(call);
            String tmp = players[index-1];
            players[index-1] = players[index];
            players[index] = tmp;
            hashMap.put(players[index-1], index-1);
            hashMap.put(players[index], index);
        }
        return players;
    }
}