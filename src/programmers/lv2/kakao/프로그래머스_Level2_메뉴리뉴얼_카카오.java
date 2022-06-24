package programmers.lv2.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


// str = 코스, count = 현재 코스 수,
// max = 코스 최대 수, idx = 현재 노드 위치, sb = 조합글자
class 프로그래머스_Level2_메뉴리뉴얼_카카오 {
    public void combi(String str, int count, int max, int idx, Map<String, Integer> map, StringBuilder sb){
        if(count == max) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        else {
            for (int i = idx; i < str.length(); i++) {
                sb.append(str.charAt(i));
                combi(str, count + 1, max, i + 1, map, sb);
                sb.delete(count, count + 1);
            }
        }
    }

    public void combi2(String str, int count, int depth, int max, boolean[] visited, Map<String, Integer> map){
        if(count == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if(visited[i])
                    sb.append(str.charAt(i));
                if(sb.length() == max)
                    break;
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        else if(depth != str.length()){
            visited[depth] = true;
            combi2(str, count -1,depth + 1, max, visited, map);
            visited[depth] = false;
            combi2(str, count, depth + 1, max, visited, map);
        }
    }
    // 이전에 각 손님들이 주문할 때 가장 많이 주문한 단품메뉴들을 코스요리 메뉴로 구성한다.
    // 2명 이상 손님의 2가지 이상 단품 메뉴이다.
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> arr = new ArrayList<>();
        // 각 문자열 오름차순 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] chArr = orders[i].toCharArray();
            Arrays.sort(chArr);
            orders[i] = String.valueOf(chArr);
        }

        for (int k : course) {
            Map<String, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for (String order : orders) {
                boolean[] visited = new boolean[order.length()];
                if (k <= order.length())
                    combi2(order, k, 0, k,visited, map);
//                    combi(order, 0, k, 0, map, sb);
            }

            System.out.println(map);

            // 구현 조합중에서 제일 많이 주문한 조합 찾기
            int max = 0;
            for (Integer value : map.values())
                max = Math.max(max, value);
            if(max >= 2) {
                for (Entry<String, Integer> countMap : map.entrySet())
                    if (countMap.getValue() == max)
                        arr.add(countMap.getKey());
            }
        }
        String[] answer = new String[arr.size()];

        int count = 0;
        for (String s : arr) {
            answer[count++] = s;
        }
        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_메뉴리뉴얼_카카오 s = new 프로그래머스_Level2_메뉴리뉴얼_카카오();
        String[] order = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};

        s.solution(order, course);
    }
}