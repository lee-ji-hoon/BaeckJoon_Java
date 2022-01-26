package inflearn.stack_queue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 첫 줄에 괄호 문자열 입력
 * 2. "(" 일 경우 push ")" 일 경우 pop
 *  2.1 ")" 인데 stack이 empty일 경우 answer = NO, break;
 * 3. "(" 즉 여는 괄호가 많은 경우도 체크 해야 함
 * 4. return answer
 */
public class Java05_01 {

    public String solution(String str) {

        String answer = "YES";

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if(String.valueOf(str.charAt(i)).equals("(")) { // "(" 인지 확인 하고 맞으면 push 아닌 경우 pop
                stack.push("(");
                // System.out.println("stack = " + stack);
            }
            else{
                if (stack.empty()) { // ")" 인 경우 무조건 pop이 아닌 stack안에 값이 비어있는지 확인해야 한다.
                    answer = "NO";
                    break;
                }
                // System.out.println("stack = " + stack);
                stack.pop();
            }
        }
        if (!stack.empty()) answer = "NO";
        // "("가 ")"보다 많은 경우 위에 for문 안의 if문으로는 찾을 수가 없으므로 마지막에 확인해줘야한다.

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java05_01 T = new Java05_01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
