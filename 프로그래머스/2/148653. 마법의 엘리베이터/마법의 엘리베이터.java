import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        List<Integer> nums = new ArrayList<>();
        while (storey > 0) {
            nums.add(storey % 10);
            storey /= 10;
        }
        int num = 0;
        int forwardNum = 0;
        
        for (int s : nums) {
            System.out.println(s);
        }
        
        
        for (int i = 0; i < nums.size(); i++) {
            num = nums.get(i);
            if (i == nums.size()-1) {
                if (num > 5) answer += (10 - num) + 1;
                else answer += num;
                continue;
            }
            if (num > 5) {
                answer += (10 - num);
                nums.set(i+1, nums.get(i+1)+1);
            } else if (num == 5) {
                forwardNum = nums.get(i+1);
                if (forwardNum >= 5) {
                    answer += (10 - num);
                    nums.set(i+1, nums.get(i+1)+1);
                } else {
                    answer += num;
                }
            }
            else {
                answer += num;
            }
        }
        
        
        
        return answer;
    }
}