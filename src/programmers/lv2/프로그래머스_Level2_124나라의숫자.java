package programmers.lv2;

class 프로그래머스_Level2_124나라의숫자 {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        int number = n;
        while(number > 0){
            int remainder = number % 3;
            number /= 3;
            if(remainder == 0) number--;
            answer = numbers[remainder] + answer;
        }
        return answer;
    }
}
