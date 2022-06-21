package inflearn.review.step5;

import java.util.Scanner;
import java.util.Stack;

public class Step5_1_올바른괄호 {
    public String solution(char[] arr){
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for(char ch : arr){
            // 여는 괄호
            if(ch == '(')
                stack.push(ch);
                // 닫는 괄호
            else{
                // 스택이 비어있으면 안됨(닫고 여는 괄호는 쌍이기때문)
                if(stack.isEmpty())
                    return "NO";
                // 여는 괄호 삭제
                stack.pop();
            }
        }

        if(!stack.isEmpty())
            return "NO";

        return answer;
    }

    public static void main(String[] args){
        Step5_1_올바른괄호 T = new Step5_1_올바른괄호();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] arr = str.toCharArray();

        System.out.print(T.solution(arr));
    }
}
