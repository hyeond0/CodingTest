import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        String rotate = s;
        for (int i = 0; i < len; i++) {
            String first = rotate.substring(0,1);
            String remain = rotate.substring(1, len);
            rotate = remain + first;
            
            Stack<Character> stack = new Stack<>();
            boolean isRight = true;
            for (char c : rotate.toCharArray()) {
                if (!isRight) break;
                if (c == ')') {
                    if (stack.isEmpty()) {
                        isRight = false;
                        break;
                    }
                    if (stack.pop() != '(') isRight = false;
                } else if (c == '}') {
                    if (stack.isEmpty()) {
                        isRight = false;
                        break;
                    }
                    if (stack.pop() != '{') isRight = false;
                } else if (c == ']') {
                    if (stack.isEmpty()) {
                        isRight = false;
                        break;
                    }
                    if (stack.pop() != '[') isRight = false;
                } else {
                    stack.add(c);
                }
            }
            if (!stack.isEmpty()) isRight = false;
            if (isRight) answer++;
        }
        return answer;
    }
}