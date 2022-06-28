package programmers.lv2.kakao;

import java.util.ArrayList;
import java.util.Collections;

// 1 2 3 4 5
// 1 1 2 2 3
// 교집합 -> 1 2 2
// 합집합 -> 1 1 2 2 3 4 5
class 프로그래머스_Level2_뉴스클러스터링_카카오 {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 대문자화
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 2개씩 합쳐진 combi 구하기
        ArrayList<String> strList1;
        ArrayList<String> strList2;
        strList1 = setCombi(str1);
        strList2 = setCombi(str2);

        // 중복 원소인 자카도 구하기 위해 정렬
        Collections.sort(strList1);
        Collections.sort(strList2);

        // 교집합 구하기
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        for(String temp : strList1){
            if(strList2.remove(temp))
                intersection.add(temp);
            union.add(temp);
        }
        // 합집합 구하기
        union.addAll(strList2);

        // 마지막 자카드 유사도 구하기
        double a = intersection.size();
        double b = union.size();

        double jakard = 1;

        if(union.size() != 0)
            jakard = a / b;

        answer = (int) (jakard * 65536);
        return answer ;
    }
    public ArrayList<String> setCombi(String str){
        ArrayList<String> strList = new ArrayList<>();
        for(int i = 0; i < str.length() - 1; i++){
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            if(Character.isLetter(a) && Character.isLetter(b))
                strList.add(Character.toString(a) + Character.toString(b));
        }
        return strList;
    }
}