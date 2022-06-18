package programmers.lv2;

class 프로그래머스_Level2_최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";

        String[] temp = s.split(" ");
        int min, max, findNumber;

        max = min = Integer.parseInt(temp[0]);
        for (String string : temp) {
            findNumber = Integer.parseInt(string);
            max = Math.max(findNumber, max);
            min = Math.min(findNumber, min);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_최댓값과최솟값 s = new 프로그래머스_Level2_최댓값과최솟값();
        s.solution("1 2 3 4");
    }
}
