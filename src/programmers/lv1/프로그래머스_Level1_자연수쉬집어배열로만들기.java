package programmers.lv1;

public class 프로그래머스_Level1_자연수쉬집어배열로만들기 {
    public int[] solution(long n) {
        String number = String.valueOf(n);

        int index = 0;
        int[] answer = new int[number.length()];
        for(int i = number.length()-1; i > 0; i--){
            answer[index++] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return answer;
    }

}
