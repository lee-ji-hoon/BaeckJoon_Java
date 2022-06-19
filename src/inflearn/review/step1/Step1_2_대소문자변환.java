package inflearn.review.step1;

import java.util.Scanner;

public class Step1_2_대소문자변환 {
    public String solution(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char find = str.charAt(i);
            if('a' <= find && find <= 'z') sb.append((char)(find - 32));
            else sb.append((char)(find + 32));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Step1_2_대소문자변환 T = new Step1_2_대소문자변환();

        Scanner in = new Scanner(System.in);
        String alpha = in.next();

        System.out.println(T.solution(alpha));
    }
}
