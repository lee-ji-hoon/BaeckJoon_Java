package programmers.lv2.kakao;

class 프로그래머스_Level2_문자열압축_카카오 {

    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length() / 2; i++){
            StringBuilder temp = new StringBuilder();
            int overlapCount = 1; // 압축
            String target = s.substring(0, i); // 기준열
            String nextTarget = "";

            for (int start = i; start <= s.length(); start +=i){
                // 문자열 자르기
                if(start + i >= s.length())
                    nextTarget = s.substring(start, s.length());
                else
                    nextTarget = s.substring(start, start + i);

                // 기준 문자열과 다음 문자열 비교
                if(target.equals(nextTarget))
                    overlapCount++;
                else if(overlapCount == 1){
                    temp.append(target);
                    target = nextTarget;
                } else{
                    temp.append(overlapCount).append(target);
                    target = nextTarget;
                    overlapCount = 1;
                }
            }

            temp.append(target);

            answer = Math.min(answer, temp.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_문자열압축_카카오 solution = new 프로그래머스_Level2_문자열압축_카카오();
        solution.solution("xababcdcdababcdcd");
    }
}
