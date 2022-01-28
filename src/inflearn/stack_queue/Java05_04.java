package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 첫 줄에 연산식 입력
 * 2. Integer Stack 생성
 * 3. for each x -> str 반복
 *  3-1. x가 숫자일 경우 push -> 현재 캐릭터형이므로 숫자는 -48 넣어서 계산하면 됨
 *  3-2. x가 숫자가 아닐 경우 -> rt = pop(), lt = pop();
 *   3-2-1. 연산자 확인 후 push(lt + rt);
 * 4. 스택에 남아있는 것이 answer이므로 get이나 peek -> 1개 밖에 안남아있으므로 get(0) == peek;
 */

public class Java05_04 {

    public int solution(String str) {

        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if(Character.isDigit(x)) stack.push(x - 48); // 캐릭터이므로 -48 한 값이 정수 값
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+') stack.push(lt + rt);
                if(x == '-') stack.push(lt - rt);
                if(x == '*') stack.push(lt * rt);
                if(x == '/') stack.push(lt / rt);
            }
        }
        answer=stack.peek();

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java05_04 T = new Java05_04();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
