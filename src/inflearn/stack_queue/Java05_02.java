package inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. 첫 줄에 문자열 str 생성
 * 2. 소괄호 사이에 존재하는 모든 문자 제거이므로 "(" 입력 받으면 ")" 받을 때 까지 모든 문자 제거
 *  2-1. "(" 다음 "(" 더 들어오고 ")" 여러 개 있는 경우도 생각하므로
 *  2-2. "(" 받을 때 마다 cnt++ 하고 ")"도 cnt2 누적 후 동일 할 때 문자 삭제
 *  2-3. 위에 조건문 빠져나올때마다 문자 answer에 누적
 * 3. return answer;
 */

public class Java05_02 {

    public String solution(String str) {

        String answer = "";

        Stack<Character> stack = new Stack<>();

        int cnt = 0, cnt2= 0;
        for (char c : str.toCharArray()) {
            if(c == '('){
                cnt++;
            } else if (c == ')') {
                cnt2++;
                if (cnt == cnt2 && cnt2 != 0) {
                    cnt = 0;
                    cnt2 = 0;
                }
            } else {
                if( cnt == 0) answer = answer + c;
                stack.push(c);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java05_02 T = new Java05_02();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(T.solution(str));
    }
}
