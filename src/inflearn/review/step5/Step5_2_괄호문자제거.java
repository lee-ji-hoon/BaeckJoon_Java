package inflearn.review.step5;

import java.util.Scanner;
import java.util.Stack;

public class Step5_2_괄호문자제거 {
    public String solution(char[] arr){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char ch : arr){
            if(ch == ')'){
                while(true){
                    char removeCh = stack.pop();
                    if(removeCh == '(')
                        break;
                }
            }else{
                stack.push(ch);
            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();
    }
    public static void main(String[] args){
        Step5_2_괄호문자제거 T = new Step5_2_괄호문자제거();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] arr = str.toCharArray();

        System.out.print(T.solution(arr));
    }
}
