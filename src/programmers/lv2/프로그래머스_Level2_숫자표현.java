package programmers.lv2;

class 프로그래머스_Level2_숫자표현 {
    public int solution(int n) {
        int answer = 1;

        for(int i = 1; i <= n / 2 + 1; i++){
            int sum = i;
            for(int j = i + 1; j <= n / 2 + 1; j++){
                sum+=j;
                if(sum == n) answer++;
                else if(sum > n) break;
            }
        }

        return answer;
    }
}
