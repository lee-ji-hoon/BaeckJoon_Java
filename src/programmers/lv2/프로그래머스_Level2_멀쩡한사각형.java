package programmers.lv2;

class 프로그래머스_Level2_멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = 0;

        long a = Math.max(w, h);
        long b = Math.min(w, h);

        long number = gcd(a, b);

        answer = (a * b) - ((a + b) - number);

        return answer;
    }

    public long gcd(long a, long b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}
