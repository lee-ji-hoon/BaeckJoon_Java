package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Kakao_2022_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 1, 중복 제거
        // 1-1. HashSet은 중복값을 허용하지 않는다는 특성 이용
        HashSet<String> reportHashSet = new HashSet<>();
        reportHashSet.addAll(Arrays.asList(report));
        /* 2. 신고 현황 배열 생성
         * 2-1. HashMap<String, ArrayList<String>>
         * 2-2. String : 신고된 사람
         * 2-3. ArrayList<String> : 신고한 사람
         */
        HashMap<String, ArrayList<String>> notifyListHashMap = new HashMap<>();
        for(String rep : reportHashSet){
            int blankIndex = rep.indexOf(" ");
            String reporter = rep.substring(0, blankIndex);
            String reported = rep.substring(blankIndex + 1);

            // 신고 된 적이 있는지 체크 하기 위한 배열 생성
            ArrayList<String> reporterList = notifyListHashMap.getOrDefault(reported, null);
            if(reporterList == null) reporterList = new ArrayList<>();

            reporterList.add(reporter);
            notifyListHashMap.put(reported, reporterList);
        }
        /*
         * 3. 신고자의 결과를 저장할 HashMap<String, Integer> 생성
         * 3-1. String : 이름
         * 3-2. Integer : 정지된 사용자를 신고한 사용자에게 알려줄 값
         */
        HashMap<String, Integer> reporterHashMap = new HashMap<>();
        for (ArrayList<String> notifyList : notifyListHashMap.values()) {
            if (notifyList.size() >= k) {
                for(String reporter : notifyList){
                    reporterHashMap.put(reporter, reporterHashMap.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        // 출력
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reporterHashMap.getOrDefault(id_list[i], 0);
        }
        return answer;
    }

    public static void main(String[] args) {
        Kakao_2022_신고결과받기 solution = new Kakao_2022_신고결과받기();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        solution.solution(id_list, report, k);
    }
}
