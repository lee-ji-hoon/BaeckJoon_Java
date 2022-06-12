package programmers.lv1;

class 프로그래머스_Level1_소수찾기 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i <= n; i++){
            boolean check = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if( i % j == 0) {
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}
