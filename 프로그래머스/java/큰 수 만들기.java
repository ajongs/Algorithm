import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            while ((!stack.isEmpty()) && k > 0) {
                if (stack.peek() < cur) {
                    k--;
                    stack.pop();
                }
                else 
                    break;
            }
            stack.push(cur);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
