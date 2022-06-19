package inflearn.review.step1;

import java.util.Scanner;

public class Step1_9_숫자만추출 {

    public int solution(String str) {
        return Integer.parseInt(str.replaceAll("[a-zA-Z]", ""));
    }
    public static void main(String[] args) {
        Step1_9_숫자만추출 T = new Step1_9_숫자만추출();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));

    }
}
