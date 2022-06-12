package programmers.lv1;

class 프로그래머스_Level1_최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        // 유클리드 호제법
        // https://namu.wiki/w/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C%20%ED%98%B8%EC%A0%9C%EB%B2%95

        int[] answer = new int[2];
        int big = Math.max(n, m);
        int small = Math.min(n, m);

        answer[0] = uclid(big, small);
        answer[1] = big * small / answer[0];

        return answer;
    }

    static int uclid(int a, int b){
        if(a % b == 0) return b;
        return uclid(b, a % b);
    }
}
