package inflearn.review.step1;

import java.util.Scanner;

public class Step1_6_중복문자제거 {
    public static void main(String[] args) {
        Step1_6_중복문자제거 T = new Step1_6_중복문자제거();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println((T.solution(str)));
    }

    public String solution(String str) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (answer.toString().indexOf(str.charAt(i)) == -1)
                answer.append(str.charAt(i));
        }

        return answer.toString();
    }
}
