package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 첫 줄에 문자열 str 생성
 * 2. 문자열 stack 추가
 *  2-1. 문자열이 ')' 인 경우
 *   2-1-1. '(' 여는 괄호 만날때 까지 pop
 *  2-2. 알파벳인경우 push
 * 3. for each 구문으로 answer에 stack 값 누적
 * 4. return answer
 */
public class Java05_02_1 {

    public String solution(String str) {

        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == ')') { // 닫는 괄호 만날 경우 아래 실행
                while (stack.pop() != '(');  // 여는괄호 '(' 만날때까지 스택의 마지막값 제거
            }
            else stack.push(x); // 알파벳인 경우 스택에 추가
        }

        for (Character character : stack) answer += character;


        return answer;
    }


    public static void main(String[] args) throws IOException {

        Java05_02_1 T = new Java05_02_1();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
