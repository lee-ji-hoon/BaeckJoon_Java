package programmers.lv1;

public class 프로그래머스_Level1_약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int count = 0;
            for(int j = 1; j * j <= i; j++){
                if(j * j == i) count++;
                else if(i % j == 0) count += 2;
            }
            if(count % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }
}
