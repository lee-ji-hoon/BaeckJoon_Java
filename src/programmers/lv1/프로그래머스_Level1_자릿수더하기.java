package programmers.lv1;

public class 프로그래머스_Level1_자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        String temp = String.valueOf(n);

        for(int i = 0; i < temp.length(); i++) answer += Integer.parseInt(String.valueOf(temp.charAt(i)));
        return answer;
    }
}
