package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 괄호로 이루어진 문자열 입력
 * 2. stack 으로 풀이 -> 열린 괄호 나올때까지 stack에 누적 후 닫힌 괄호 나올 때 바로 열린 괄호인지 체크
 * 3. str.length() 만큼 반복
 *  3-1. str.charAt(i) == '(' 인 경우 -> stack.push('(')
 *  3-2. else -> 닫힌 괄호(')') 이므로  pop()
 *   3-2-1. 닫힌 괄호 전에 열린 괄호 ('(')인 경우 answer+=stack.size() 누적
 *   3-2-2. else -> answer 값 누적
 * 4. return answer;
 */

public class Java05_05 {

    public int solution(String str) {

        int answer=0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){

            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') answer += stack.size();
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java05_05 T = new Java05_05();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
