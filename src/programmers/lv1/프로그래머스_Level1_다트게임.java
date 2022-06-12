package programmers.lv1;

import java.util.Stack;

class 프로그래머스_Level1_다트게임 {
    // S(Single)1제곱 D(Double)2제곱 Triple(T)3제곱
    // * : 바로 이전 점수 2배 // # 해당 점수 마이너스
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        // 숫자 + 제곱횟수 + *2 || *(-1)
        // 숫자 + 제곱횟수는 필수이고 옵션은 부가사항
        int count = 0;
        while(count != dartResult.length()){
            // 다트 넘버 구하기
            int dartNumber = Integer.parseInt(String.valueOf(dartResult.charAt(count)));
            char bonus;
            count++;
            // 다트 넘버가 10인경우 다음 idx 까지가 다트넘버이다.
            if(dartResult.charAt(count) == '0') {
                // 다트 넘버 10으로 갱신
                dartNumber = 10;
                count++;
            }

            bonus = dartResult.charAt(count);
            // 0 -> 1 -> 2
            // 보너스 계산하기
            switch(bonus){
                case 'D' : {
                    dartNumber *= dartNumber;
                    break;
                }
                case 'T' : {
                    dartNumber = dartNumber * dartNumber * dartNumber;
                    break;
                }
            }
            // 만약 스타상이 존재한다면?
            count++;
            if(count != dartResult.length() && (dartResult.charAt(count) == '*' || dartResult.charAt(count) == '#')){
                char option = dartResult.charAt(count);

                switch(option){
                    case '*' : {
                        dartNumber *= 2;
                        if(!stack.empty()) answer = answer - stack.peek() + dartNumber + stack.peek() * 2;
                        else answer = dartNumber;
                        break;
                    }
                    case '#' : {
                        dartNumber *= -1;
                        answer = answer + dartNumber;
                        break;
                    }
                }
                count++;
            } else answer += dartNumber;
            stack.push(dartNumber);
        }
        return answer;
    }

    public static void main(String[] args) {
        String dart = "1S*2T*3S";

        프로그래머스_Level1_다트게임 s = new 프로그래머스_Level1_다트게임();
        s.solution(dart);
    }
}
