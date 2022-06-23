package programmers.lv2.kakao;

class 프로그래머스_Level2_K진수에서소수갯수구하기_카카오 {
    // n을 k진수로 바꾸기
    public int solution(int n, int k) {
        int answer = 0;
        String convert = "";
        if(k == 10)
            convert = String.valueOf(n);
        else
            convert = convert(n, k);

//        String s = Integer.toString(n, k);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < convert.length(); i++) {
            char ch = convert.charAt(i);
            if(ch == '0') {
                if (!sb.toString().equals("") && isPrime(sb))
                    answer++;

                sb.delete(0, sb.length());
            } else
                sb.append(ch);
        }

        if(sb.length() > 0)
            if(isPrime(sb))
                answer++;

        return answer;
    }

    private boolean isPrime(StringBuilder sb) {
        long num = Long.parseLong(sb.toString());

        if(num == 1 || num == 0)
            return false;

        for(int i = 2; i <= Math.sqrt(num); i++)
            if(num % i == 0)
                return false;

        return true;
    }

    private String convert(int n, int k) {
        if(n == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int remainder = n % k;
            n = n / k;

            if(remainder > 9)
                sb.append((char) (remainder + 55));
            else
                sb.append(remainder);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        프로그래머스_Level2_K진수에서소수갯수구하기_카카오 s = new 프로그래머스_Level2_K진수에서소수갯수구하기_카카오();
        int solution = s.solution(437674, 3);
        System.out.println("solution = " + solution);
    }
}
