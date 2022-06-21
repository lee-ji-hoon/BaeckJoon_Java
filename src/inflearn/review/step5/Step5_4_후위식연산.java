package inflearn.review.step5;

import java.util.Scanner;
import java.util.Stack;

public class Step5_4_후위식연산 {
    public int solution(String str){
        Stack<Integer> stack = new Stack<>();
        char[] temp = str.toCharArray();

        int answer = 0;
        for(int i = 0; i < temp.length; i++){
            if(Character.isDigit(temp[i]))
                stack.push(Integer.parseInt(String.valueOf(temp[i])));
            else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                char postfix = temp[i];
                switch(postfix){
                    case '+' : {
                        answer = num2 + num1;
                        break;
                    }
                    case '-' : {
                        answer = num2 - num1;
                        break;
                    }
                    case '*' : {
                        answer = num2 * num1;
                        break;
                    }
                    case '/' : {
                        answer = num2 / num1;
                        break;
                    }
                }
                stack.push(answer);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Step5_4_후위식연산 T = new Step5_4_후위식연산();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.print(T.solution(str));
    }
}