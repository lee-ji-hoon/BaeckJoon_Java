package programmers.lv2.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 프로그래머스_Level2_순위검색_카카오_효율성통과 {
    public int[] solution (String[] info, String[] query){
        // 1. info를 기반으로 HashMap을 만든다.
        Map<String, ArrayList<Integer>> hashMap = new HashMap<>();

        for (String i : info) {
            String[] data = i.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer value = Integer.parseInt(data[4]);
            for (String lang : languages) {
                for (String job : jobs) {
                    for (String exp : exps) {
                        for (String food : foods) {
                            String[] keyData = {lang, job, exp, food};
                            String key = String.join("", keyData);

                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<>());

                            arr.add(value);
                            hashMap.put(key, arr);
                        }
                    }
                }
            }
        }
        // 2. 각 HashMap의 Value를 오름차순으로 정렬한다.
        for (ArrayList<Integer> arr : hashMap.values())
            arr.sort(null);

        // 3. query 조건에 맞는 지원자를 갖고온다.
        int[] answer = new int[query.length];
        int i = 0;
        for (String q : query) {
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];

            String key = String.join("", data);

            if (hashMap.containsKey(key)) {
                ArrayList<Integer> list = hashMap.get(key);
                // 4. 이분탐색을 이용해 lower-bound를 찾는다.
                int left = 0;
                int right = list.size();

                while(left < right){
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= target)
                        right = mid;
                    else
                        left = mid +1;
                }
                answer[i] = list.size() - left;
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_순위검색_카카오_효율성통과 s = new 프로그래머스_Level2_순위검색_카카오_효율성통과();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] solution = s.solution(info, query);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
