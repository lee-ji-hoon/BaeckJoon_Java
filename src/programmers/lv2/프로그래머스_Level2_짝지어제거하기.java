package programmers.lv2;

import java.util.Stack;

class 프로그래머스_Level2_짝지어제거하기 {
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        char[] toChar = s.toCharArray();

        for (char c : toChar) {
            if (stack.isEmpty())
                stack.push(c);
            else {
                if (stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_짝지어제거하기 s = new 프로그래머스_Level2_짝지어제거하기();
        s.solution("cdcd");
    }
}
