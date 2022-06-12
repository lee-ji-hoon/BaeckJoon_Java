package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;

class 프로그래머스_Level1_문자열내림차순으로배치하기 {
    public String solution(String s) {

        ArrayList<Character> stringList = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) stringList.add(s.charAt(i));
        stringList.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(Character string : stringList) sb.append(string);

        String answer = sb.toString();
        return answer;
    }
}
