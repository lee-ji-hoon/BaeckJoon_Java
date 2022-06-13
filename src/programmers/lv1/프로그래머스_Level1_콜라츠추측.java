package programmers.lv1;

public class 프로그래머스_Level1_콜라츠추측 {
    public int solution(int num) {
        int answer = 0;

        for(int i = 0; i < 500; i++){
            System.out.println("num = " + num);
            if(num == 1) break;
            if(num % 2 == 1) {
                num = num * 3 + 1;
            } else{
                num /= 2;
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level1_콜라츠추측 s = new 프로그래머스_Level1_콜라츠추측();
        s.solution(6);
    }
}

