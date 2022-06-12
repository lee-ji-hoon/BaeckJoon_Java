package programmers.lv1;

import java.util.Arrays;
class 프로그래머스_Level1_정수내림차순으로배치하기 {
    public long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String string : list) sb.append(string);
        sb.reverse();

        long answer = Long.parseLong(sb.toString());
        return answer;

    }
}
