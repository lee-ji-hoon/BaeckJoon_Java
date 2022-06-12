package programmers.lv1;
import java.util.ArrayList;
import java.util.Collections;

class 프로그래머스_Level1_문자열내맘대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        ArrayList<String> stringsArrayList = new ArrayList<>();
        // 예제 1번의 경우
        // usun, ebed, acar로 만들어서 리스트에 저장
        for (String string : strings) stringsArrayList.add(string.charAt(n) + string);

        // 맨 앞글자를 기준으로 정렬하는 Collections.sort 사용
        Collections.sort(stringsArrayList);

        int size = stringsArrayList.size();
        String[] answer = new String[size];
        // 맨 앞글자만 제외하고 answer에 저장
        for (int i = 0; i < size; i++)  answer[i] = stringsArrayList.get(i).substring(1);

        return answer;
    }
}
