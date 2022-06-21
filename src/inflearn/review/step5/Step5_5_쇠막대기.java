package inflearn.review.step5;

import java.util.Scanner;
import java.util.Stack;

public class Step5_5_쇠막대기 {
    public int solution(String str){
        int answer = 0;
        char[] toChar = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < toChar.length; i++){
            char ch = toChar[i];
            if(ch == '(')
                stack.push(ch);
            else{
                stack.pop();
                if(toChar[i-1] == '(')
                    answer += stack.size();
                else
                    answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Step5_5_쇠막대기 T = new Step5_5_쇠막대기();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.print(T.solution(str));
    }
}
