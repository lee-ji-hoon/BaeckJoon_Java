package programmers.lv1;

class 프로그래머스_Level1_수박수박수박수 {
    public String solution(int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(i % 2 == 1) sb.append("수");
            else sb.append("박");
        }

        answer = sb.toString();
        return answer;
    }
}
