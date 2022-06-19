package inflearn.review.step1;

import java.util.Scanner;

public class Step1_12_암호 {
    StringBuilder sb = new StringBuilder();
    public String solution(int N, String str){
        // 1. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.
        str = str.replaceAll("#", "1");
        str = str.replaceAll("\\*", "0");
        int length = str.length() / N;

        // 2. 첫번째만 따로 저장
        decimal(str.substring(0, length), sb);
        N--;
        // 3. 2진수 N개씩 끊어서 저장
        int count = 1;
        while(N >= count){
            // 3. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
            String subString = str.substring(count * length, (count + 1) * length);
            decimal(subString, sb);
            count++;
        }
        // 4. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.
        return sb.toString();
    }

    private void decimal(String str, StringBuilder sb) {
        sb.append((char)Integer.parseInt(str, 2));
    }

    public static void main(String[] args){
        Step1_12_암호 T = new Step1_12_암호();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String str= sc.next();

        System.out.print(T.solution(N, str));
    }
}