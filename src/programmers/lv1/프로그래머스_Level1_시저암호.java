package programmers.lv1;

class 프로그래머스_Level1_시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++) {
            char tempChar = s.charAt(i);
            if(tempChar == ' ') {
                sb.append(tempChar);
                continue;
            }
            // 소문자
            if(Character.isLowerCase(tempChar)){
                if(tempChar + n > 'z') sb.append((char)(tempChar + n - 26));
                else sb.append((char)(tempChar + n));
                // 대문자
            } else{
                if(tempChar + n > 'Z') sb.append((char)(tempChar + n - 26));
                else sb.append((char)(tempChar + n));
            }
        }

        answer = sb.toString();
        return answer;
    }
}