package programmers.lv1;

class 프로그래머스_Level1_가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int middleIdx = s.length() / 2;
        if(s.length() % 2 == 0){
            sb.append(s.charAt(middleIdx-1)).append(s.charAt(middleIdx));
        } else {
            sb.append(s.charAt(middleIdx));
        }

        answer = sb.toString();
        return answer;
    }
}
