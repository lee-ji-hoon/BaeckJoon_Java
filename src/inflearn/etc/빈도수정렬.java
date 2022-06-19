package inflearn.etc;

import java.util.*;

public class 빈도수정렬 {
    public String solution(String s){
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            String temp = String.valueOf(s.charAt(i));
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> stringIntegerEntry : list)
            sb.append(String.valueOf(stringIntegerEntry.getKey()).repeat(Math.max(0, stringIntegerEntry.getValue())));

        answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) {
        빈도수정렬 T = new 빈도수정렬();
        System.out.println(T.solution("aaAAcccbbbBB"));//bbbcccaaAABB
        System.out.println(T.solution("kdkDKKGkdkgks"));//kkkkkddKKsDGg
        System.out.println(T.solution("ckdowiskjgwigAGD"));//wwggiikkAcsdDGjo
    }
}
