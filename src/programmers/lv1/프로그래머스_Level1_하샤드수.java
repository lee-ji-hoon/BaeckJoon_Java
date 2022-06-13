package programmers.lv1;

public class 프로그래머스_Level1_하샤드수 {
    public boolean solution(int x) {
        boolean answer = true;

        String[] temp = String.valueOf(x).split("");

        int sum = 0;
        for(String string : temp) sum += Integer.parseInt(string);

        if(x % sum != 0) answer = false;
        return answer;
    }
}
