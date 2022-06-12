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
            if(count % 2 == 0) {
                if(Character.isLowerCase(ch)) sb.append(String.valueOf(ch).toUpperCase());
                else sb.append(ch);
            } else {
                if(Character.isUpperCase(ch)) sb.append(String.valueOf(ch).toLowerCase());
                else sb.append(ch);
            }
            count++;
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level1_이상한문자만들기 s = new 프로그래머스_Level1_이상한문자만들기();
        s.solution("try hello world");
    }
}