package programmers.lv2;

class 프로그래머스_Level2_조이스틱 {
    /* 상하 조작으로 원하는 알파벳 찾기
     * 'A'와 'C'인 경우
     * 1. 조이스틱을 위로 조작할 경우 (알파벳 - A)
     * -> 'C' - 'A' => 2
     *
     * 2. 조이스틱을 아래로 조작할 경우 (26 - 알파벳 - A)
     * -> 26 - 'C' - 'A' = 24
     *
     * 둘 중의 최소값으로 구하면 된다. -> Math.min 사용
     */

    /* 좌우 조작으로 커서 위치 조정하기.
     * 1. 처음부터 쭉 오른쪽으로 가는 경우
     * -> 가장 일반 적인 경우로 length() - 1
     *
     * 2. 오른쪽으로 갔다가 다시 리턴하여 왼쪽으로 가는 경우
     * -> BBAAAAAYYY의 경우 BB까지 갔다가 YYY로 돌아가 완성하는게 더 낫다.
     *
     * 3. 왼쪽으로 갔다가 다시 리턴하여 오른쪽으로 가는 경우
     * -> CCCAAAAAY의 경우 처음부터 왼쪼긍로 움직여 Y를 완성해주고 다시 오른쪽으로 돌아가 CCC를 완성해준다.
     */
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int move = name.length() - 1;

        for(int i = 0; i < length; i++){
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));

            // 연속되는 A 갯수 확인
            int index = i + 1;
            while(index < length && name.charAt(index) == 'A') index++;

            System.out.println("index = " + index);

            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_조이스틱 solution = new 프로그래머스_Level2_조이스틱();
        solution.solution("CDAAABCD");
    }
}