package programmers.lv1;

public class 프로그래머스_Level1_짝수와홀수 {
    public String solution(int num) {
        String answer = "Odd";

        if(num % 2 == 0) answer = "Even";

        return answer;
    }
}
