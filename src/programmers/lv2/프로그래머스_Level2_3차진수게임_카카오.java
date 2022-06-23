package programmers.lv2;

class 프로그래머스_Level2_3차진수게임_카카오 {

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;
        while (sb.length() < m * t)
            sb.append(getConventN(num++, n));

        for (int i = p - 1; i < m * t; i += m)
            answer.append(sb.charAt(i));

        return answer.substring(0, t);
    }

    // 10진수를 N진수로 변환
    public static String getConventN(int num, int n) {
        StringBuilder sb = new StringBuilder();

        if(num == 0)
            return "0";

        while(num  > 0){
            int remainder = num % n;
            if(remainder > 9)
                sb.append((char) (remainder + 55));
            else
                sb.append(remainder);
            num = num / n;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        int n = 16; // 진법 n
        int t = 16; // 구할 숫자의 갯수 t
        int m = 2; // 게임에 참가하는 인원 m
        int p = 1; // 튜브의 순서 p

        String answer = solution(n, t, m, p);
        System.out.println(answer);
    }
}
