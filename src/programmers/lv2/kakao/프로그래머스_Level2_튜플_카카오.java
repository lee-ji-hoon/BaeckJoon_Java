package programmers.lv2.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class 프로그래머스_Level2_튜플_카카오 {
    public int[] solution(String s) {
        // 1. 괄호 제거
        s = s.replace("{{", "{");
        s = s.replace("}}", "}");
        s = s.replace("},", "}");
        // 2. 배열로 만든후 정렬 sort
        ArrayList<String> tupleList = findTuple(s);
        Comparator<String> c = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        Collections.sort(tupleList, c);
        // 3. 새롭게 추가되는 숫자만 추가
        ArrayList<String> tupleSet = new ArrayList<>();
        for(String tuple : tupleList){
            String[] temp = tuple.split(",");

            for (String value : temp)
                if (!tupleSet.contains(value))
                    tupleSet.add(value);
        }
        // 4. answer 배열에 누적
        int[] answer = new int[tupleSet.size()];
        int count = 0;
        for(String temp : tupleSet)
            answer[count++] = Integer.parseInt(temp);
        return answer;
    }

    public ArrayList<String> findTuple(String str){
        ArrayList<String> tupleList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);

            if(temp == '}'){
                tupleList.add(sb.toString());
                sb.setLength(0);
            }
            else{
                if(Character.isDigit(temp) || temp == ',')
                    sb.append(temp);
            }
        }
        return tupleList;
    }
}
