package programmers.lv1;

class 프로그래머스_Level1_문자열내p와y의개수 {
    boolean solution(String s) {
        boolean answer = true;

        int p = 0;
        int y = 0;

        s = s.toUpperCase();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'P') p++;
            if(s.charAt(i) == 'Y') y++;
        }

        if(p != y) answer = false;
        return answer;
    }
}
