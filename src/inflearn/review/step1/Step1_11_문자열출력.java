package inflearn.review.step1;

import java.util.Scanner;

public class Step1_11_문자열출력 {
    public String solution(String str){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        // 1. 처음부터 끝 - 1까지 문자 꺼내오기
        while(idx < str.length()){
            int count = 1;
            // 2. 현재 문자와 다음문자가 달라질때까지 비교
            char current = str.charAt(idx);
            while(true){
                // 3. 다음 문자가 존재하지 않을 경우 idx++ -> 이전 while문 종료 시키기 위해
                if(idx + 1 == str.length()) {
                    idx++;
                    break;
                }
                // 4. 다음 문자가 비교할 문자와 같다면 count++
                char next = str.charAt(++idx);
                if(current == next)
                    count++;
                else break;
            }

            // 5. 만약 count가 1이면 count는 출력문에서 빼야 한다.
            if(count != 1)
                sb.append(current).append(count);
            else
                sb.append(current);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Step1_11_문자열출력 T = new Step1_11_문자열출력();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.print(T.solution(str));
    }
}
