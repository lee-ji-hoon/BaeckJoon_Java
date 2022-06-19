package inflearn.review.step1;

import java.util.Scanner;

public class Step1_1_문자찾기 {
    public int solution(String alpha, String find){
        int answer = 0;
        String upperAlpha = alpha.toUpperCase();
        String upperFind = find.toUpperCase();

        for(int i = 0; i < alpha.length(); i++){
            if(String.valueOf(upperAlpha.charAt(i)).equals(upperFind)) answer++;
        }
        return answer;
    }
    public static void main(String[] args){
        Step1_1_문자찾기 T = new Step1_1_문자찾기();
        Scanner in=new Scanner(System.in);

        String alpha = in.next();
        String find = in.next();
        System.out.println(T.solution(alpha, find));
    }
}
