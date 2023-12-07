import java.util.*;
class Solution {
    static Booking[] a;
    public int solution(String[][] book_time) {
        a = new Booking[book_time.length];
        for (int i = 0; i < book_time.length; i++) {
            String startHour = book_time[i][0].split(":")[0];
            String startMinute = book_time[i][0].split(":")[1];
            String endHour = book_time[i][1].split(":")[0];
            String endMinute = book_time[i][1].split(":")[1];
            int startTime = Integer.parseInt(startHour) * 60 + Integer.parseInt(startMinute);
            int endTime = Integer.parseInt(endHour) * 60 + Integer.parseInt(endMinute);
            a[i] = new Booking(startTime, endTime);
        }
        
        Arrays.sort(a);
        PriorityQueue<Integer> room = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (Booking b : a) {
            if (room.isEmpty()) {
                room.add(b.endTime + 10);
                continue;
            }
            // 비어있지 않다면
            if (b.startTime >= room.peek()) {
                room.poll();
                room.add(b.endTime + 10);
            } else {
                room.add(b.endTime + 10);
            }
        }
        return room.size();
    }
    
    static class Booking implements Comparable<Booking> {
        private int startTime;
        private int endTime;
        
        public Booking(int start, int end) {
            this.startTime = start;
            this.endTime = end;
        }
        
        @Override
        public int compareTo(Booking other) {
            if (startTime == other.startTime) return endTime - other.endTime;
            return startTime - other.startTime;
        }
    }
}