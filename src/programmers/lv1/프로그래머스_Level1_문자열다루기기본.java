package programmers.lv1;

class 프로그래머스_Level1_문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;
        int length = s.length();

        if(length < 4 || length > 6 || length == 5) return false;

        for(int i = 0; i < length; i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }

        return answer;
    }
}
