package programmers.lv1;

public class 프로그래머스_Level1_없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) answer -= number;

        return answer;
    }
}
