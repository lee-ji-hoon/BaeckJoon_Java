package programmers.lv1;

class 프로그래머스_Level1_약수의합 {
    public int solution(int n) {
        int answer = n;

        for (int i = 1; i <= n / 2; i++){
            if(n % i == 0) answer += i;
        }

        return answer;
    }
}
