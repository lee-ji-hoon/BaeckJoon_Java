package programmers.lv1;

class 프로그래머스_Level1_이상한문자만들기 {
    public String solution(String s) {
        String answer = "";

        // 대문자 소문자 아시키 코드 값 차이 32
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ') {
                count = 0;
                sb.append(" ");
                continue;
            }
            sb.append(count % 2 == 0 ? String.valueOf(ch).toUpperCase() : String.valueOf(ch).toLowerCase());
            count++;
        }
        answer = sb.toString();
        return answer;
    }
}