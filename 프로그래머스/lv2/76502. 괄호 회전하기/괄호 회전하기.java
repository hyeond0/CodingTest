import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> charDeque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i ++) {
            charDeque.offer(s.charAt(i));
        }

        for (int i = 0; i < charDeque.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (char c: charDeque) {
                sb.append(c);
            }
            if (correctString(sb)) answer++;
            charDeque.offer(charDeque.poll());
        }
        return answer;
    }
    
    private boolean correctString(StringBuilder sb) {
         Stack<Character> stack = new Stack<>();
        boolean check = true;
        for (int i=0; i< sb.length(); i++) {
            switch(sb.charAt(i)) {
                case '(':
                    stack.add('(');
                    break;
                case '{':
                    stack.add('{');
                    break;
                case '[':
                    stack.add('[');
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else check = false;
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    else check = false;
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else check = false;
                    break;
            }
        }
        if (stack.isEmpty() && check) return true;
        else return false;
    }
}