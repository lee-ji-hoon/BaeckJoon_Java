package programmers.lv1;

class 프로그래머스_Level1_정수제곱근판별 {
    public long solution(long n) {
        long answer = -1;

        for(long i = 1; i <= n; i++){
            if(i * i == n) {
                answer = (i+1) * (i+1);
                break;
            }
        }
        return answer;
    }
}
